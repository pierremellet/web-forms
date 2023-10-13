package webforms.server.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import webforms.server.api.ValidateApiDelegate;
import webforms.server.fields.FieldsManager;
import webforms.server.fields.api.ConfigurableFieldPlugin;
import webforms.server.fields.api.FieldPlugin;
import webforms.server.fields.api.SimpleFieldPlugin;
import webforms.server.model.FormField;
import webforms.server.model.FormFieldValidation;
import webforms.server.repositories.FormConfigDocument;
import webforms.server.repositories.FormConfigRepository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ValidateService implements ValidateApiDelegate {

    @Autowired
    private FormConfigRepository formConfigRepository;

    @Autowired
    private FieldsManager fieldsManager;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public ResponseEntity<FormFieldValidation> validateField(FormFieldValidation fieldValidation) throws Exception {

        FormConfigDocument formConfig = this.formConfigRepository.findByFormId(fieldValidation.getFormId());

        if (formConfig == null) {
            throw new Exception("Missing FormConfig");
        }

        final AtomicReference<FormField> formField = new AtomicReference<>();

        formConfig.getSections().forEach(s -> {
            s.getFields().forEach(f -> {
                if (f.getId().equals(fieldValidation.getFieldId())) {
                    formField.set(f);
                }
            });
        });

        Optional<FieldPlugin> fieldPluginOpt = this.fieldsManager.getField(formField.get());
        FieldPlugin fieldPlugin = fieldPluginOpt.get();
        Object val = fieldValidation.getFieldValue();

        if (fieldPlugin instanceof ConfigurableFieldPlugin<?, ?>) {
            final Object fieldConfig = formField.get().castConfig(this.objectMapper, ((ConfigurableFieldPlugin<?, ?>) fieldPlugin).getConfigTypeName());
            fieldValidation.setValide(((ConfigurableFieldPlugin<Object, Object>) fieldPlugin).isValueValid(val, fieldConfig));
        }

        if (fieldPlugin instanceof SimpleFieldPlugin<?>)
            fieldValidation.setValide(((SimpleFieldPlugin<Object>) fieldPlugin).isValueValid(val));

        return ResponseEntity.ok(fieldValidation);
    }
}
