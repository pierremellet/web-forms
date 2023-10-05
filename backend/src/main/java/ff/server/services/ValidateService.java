package ff.server.services;

import ff.server.fields.FieldsManager;
import ff.server.fields.api.ConfigurableFieldPlugin;
import ff.server.fields.api.FieldPlugin;
import ff.server.fields.api.SimpleFieldPlugin;
import ff.server.api.ValidateApiDelegate;
import ff.server.model.FormFieldValidation;
import ff.server.model.FormField;
import ff.server.repositories.FormConfigDocument;
import ff.server.repositories.FormConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ValidateService implements ValidateApiDelegate {

    @Autowired
    private FormConfigRepository formConfigRepository;

    @Autowired
    private FieldsManager fieldsManager;
    
    @Override
    public ResponseEntity<FormFieldValidation> validateField(FormFieldValidation fieldValidation) throws Exception {

        FormConfigDocument formConfig = this.formConfigRepository.findByFormId(fieldValidation.getFormId());

        if(formConfig == null){
            throw new Exception("Missing FormConfig");
        }

        final AtomicReference<FormField> formField = new AtomicReference<>();

        formConfig.getSections().forEach(s -> {
            s.getFields().forEach(f -> {
                if(f.getId().equals(fieldValidation.getFieldId())){
                    formField.set(f);
                }
            });
        });

        Optional<FieldPlugin> fieldPluginOpt = this.fieldsManager.getField(formField.get());
        FieldPlugin fieldPlugin = fieldPluginOpt.get();
        Object val = fieldValidation.getFieldValue();

        if(fieldPlugin instanceof ConfigurableFieldPlugin<?,?>){
            @NotNull Object fieldConfig = formField.get().getConfig();
            fieldValidation.setValide(((ConfigurableFieldPlugin<Object,Object>)fieldPlugin).isValueValid(val, fieldConfig));
        }

        if(fieldPlugin instanceof SimpleFieldPlugin<?>)
            fieldValidation.setValide(((SimpleFieldPlugin<Object>) fieldPlugin).isValueValid(val));

        return ResponseEntity.ok(fieldValidation);
    }
}
