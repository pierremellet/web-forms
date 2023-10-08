package webforms.server.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import webforms.server.fields.FieldsManager;
import webforms.server.fields.api.ConfigurableFieldPlugin;
import webforms.server.fields.api.FieldPlugin;
import webforms.server.api.FormConfigsApiDelegate;
import webforms.server.model.*;
import webforms.server.repositories.FormConfigDocument;
import webforms.server.repositories.FormConfigRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FormConfigService implements FormConfigsApiDelegate {

    @Autowired
    private FormConfigRepository formConfigRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FieldsManager fieldsManager;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public ResponseEntity<FormConfig> createOrUpdateForm(FormConfig formConfig) throws Exception {

        final FormConfigValidation validation = this.validateFormConfig(formConfig);
        if (validation.hasError()) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), this.objectMapper.writeValueAsString(validation))).build();
        }

        final FormConfigDocument formConfigDocument = modelMapper.map(formConfig, FormConfigDocument.class);

        if (formConfigDocument.getFormId() == null) {
            formConfigDocument.setFormId(UUID.randomUUID().toString());
            final FormConfigDocument res = this.formConfigRepository.insert(formConfigDocument);
            return ResponseEntity.created(URI.create("/api/v1/formsConfig/" + res.getFormId())).body(modelMapper.map(res, FormConfig.class));
        }

        if (formConfigDocument.getFormId() != null) {
            final FormConfigDocument formConfigDocumentFromDb = this.formConfigRepository.findByFormId(formConfigDocument.getFormId());
            if (formConfigDocumentFromDb != null) {
                formConfigDocument.id = formConfigDocumentFromDb.id;
            }

            final FormConfig upsertFormConfig = modelMapper.map(this.formConfigRepository.save(formConfigDocument), FormConfig.class);
            return ResponseEntity.ok(upsertFormConfig);
        }

        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<FormConfig> getFormConfig(String formId) {
        final FormConfig formConfig = this.formConfigRepository.findByFormId(formId);
        if (formConfig == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(formConfig);
    }

    @Override
    public ResponseEntity<List<FormConfig>> listForms() {
        final List<FormConfigDocument> forms = this.formConfigRepository.findAll();
        final List<FormConfig> formConfigs = forms.stream().map(d -> this.modelMapper.map(d, FormConfig.class)).toList();
        return ResponseEntity.ok(formConfigs);
    }


    public FormConfigValidation validateFormConfig(FormConfig formConfig) {

        List<FormError> fieldErrors = validateFields(formConfig);
        List<FormError> routerError = validateRouter(formConfig);
        List<FormError> sectionIdsError = validateSectionIDs(formConfig);
        List<FormError> fieldIdsError = validateFieldIDs(formConfig);
        List<FormError> fieldDisplayError = validateDisplayExp(formConfig);
        List<FormError> fieldConfigurationError = validateFieldConfiguration(formConfig);

        return new FormConfigValidation(fieldErrors, routerError, sectionIdsError, fieldIdsError, fieldDisplayError, fieldConfigurationError);


    }

    private List<FormError> validateFieldConfiguration(FormConfig formConfig) {
        final List<FormError> errors = new ArrayList<>();
        formConfig.getSections().forEach(section -> {
            section.getFields().forEach(formField -> {
                try {
                    Optional<FieldPlugin> optField = this.fieldsManager.getField(formField);
                    if (optField.isPresent()) {
                        FieldPlugin f = optField.get();
                        Object fieldConfigObj = formField.getConfig();
                        String fieldConfigStr = this.objectMapper.writeValueAsString(fieldConfigObj);
                        if (f instanceof ConfigurableFieldPlugin<?, ?>) {
                            final Class<?> fieldConfigType = ((ConfigurableFieldPlugin<?, ?>) f).getConfigTypeName();
                            final Object fieldConfig = this.objectMapper.readValue(fieldConfigStr, fieldConfigType);

                            if (!((ConfigurableFieldPlugin) f).isConfigValid(fieldConfig)) {
                                throw new Exception("Configuration is invalid");
                            }
                        }

                    }
                } catch (Exception e) {
                    final FormError error = new FormError();
                    error.setId(formField.getId());
                    error.setMessage("Wrong configuration : " + e.getMessage());
                    errors.add(error);
                }
            });
        });
        return errors;
    }

    public List<FormError> validateFields(FormConfig formConfig) {
        final List<FormError> errors = new ArrayList<>();

        final Set<String> availableTypes = this.fieldsManager.getFieldTypes();

        formConfig.getSections().forEach(section -> {
            section.getFields().forEach(field -> {
                if (field.getType() != null && !availableTypes.contains(field.getType())) {
                    final FormError fieldError = new FormError();
                    fieldError.setId(field.getId());
                    fieldError.setMessage("Wrong field type : " + field.getType());
                    errors.add(fieldError);
                }
            });
        });

        return errors;
    }

    public List<FormError> validateRouter(FormConfig formConfig) {
        List<FormError> errors = new ArrayList<>();
/*
        List<String> availableRouters = getRouterClassNames();

        if (formConfig.getRouter() != null && !availableRouters.contains(formConfig.getRouter().getRouterClass())) {
            errors.add("Missing router class : " + formConfig.getRouter().getRouterClass());
        }

        if (formConfig.getRouter() != null) {
            List<String> routerConfigValidationErrors = validateRouterConfig(formConfig.getRouter().getRouterClass(), formConfig.getRouter().getRouterConfig());
            if (!routerConfigValidationErrors.isEmpty()) {
                errors.add("Router config is invalid : " + String.join(", ", routerConfigValidationErrors));
            }
        }
*/
        return errors;
    }

    public List<FormError> validateFieldIDs(FormConfig formConfig) {
        List<FormError> errors = new ArrayList<>();

        final Set<String> fieldIds = new HashSet<>();

        // Valider les doublons dans les identifiants de champ
        for (FormSection section : formConfig.getSections()) {
            for (FormField field : section.getFields()) {
                if (field != null && !fieldIds.add(field.getId())) {
                    FormError formError = new FormError();
                    formError.setId(field.getId());
                    formError.setMessage("Duplicate field ID: " + field.getId());
                }
            }
        }

        return errors;
    }

    public List<FormError> validateSectionIDs(FormConfig formConfig) {
        List<FormError> errors = new ArrayList<>();

        final Set<String> sectionIds = new HashSet<>();

        // Valider les doublons dans les identifiants de section
        for (FormSection section : formConfig.getSections()) {
            if (!sectionIds.add(section.getId())) {
                final FormError formError = new FormError();
                formError.setId(section.getId());
                formError.setMessage("Duplicate section ID: " + section.getId());
                errors.add(formError);
            }

            if(!isDNSCompliant(section.getId())){
                final FormError formError = new FormError();
                formError.setId(section.getId());
                formError.setMessage("Section ID not DNS compliant: " + section.getId());
                errors.add(formError);
            }
        }

        return errors;
    }

    private List<FormError> validateDisplayExp(FormConfig formConfig) {
        List<FormError> errors = new ArrayList<>();

        formConfig.getSections().forEach(section -> {
            section.getFields().stream()
                    .filter(field -> field.getDisplay() != null)
                    .forEach(field -> {

                    });
        });

        return errors;
    }


    public static boolean isDNSCompliant(String input) {
        String dnsRegex = "^(?!-)[A-Za-z0-9-]{1,63}(?<!-)(\\.[A-Za-z0-9-]{1,63})*$";
        Pattern pattern = Pattern.compile(dnsRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
