package ff.server.fields;

import ff.server.fields.api.FieldPlugin;
import ff.server.model.FormField;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FieldsManager {


    @Autowired
    protected Set<FieldPlugin> registry;

    public Set<String> getFieldTypes() {
        return this.registry.stream().map(FieldPlugin::getTypeName).collect(Collectors.toSet());
    }

    public Optional<FieldPlugin> getField(FormField formField) {
        return this.registry.stream().filter(f -> f.getTypeName().equals(formField.getType())).findFirst();
    }

    public Optional<FieldPlugin> getField(String fieldType) {
        return this.registry.stream().filter(f -> f.getTypeName().equals(fieldType)).findFirst();
    }


}
