package ff.server.fields.plugins.inputDate;

import ff.server.fields.api.ConfigurableFieldPlugin;
import org.springframework.stereotype.Component;

@Component
public class InputDate implements ConfigurableFieldPlugin<String, InputDateConfig> {
    @Override
    public String getTypeName() {
        return "INPUT_DATE";
    }

    @Override
    public boolean isConfigValid(InputDateConfig fieldPluginConfig) {
        return !fieldPluginConfig.getRegex().isEmpty();
    }

    @Override
    public boolean isValueValid(String fieldValue, InputDateConfig fieldConfig) {
        return fieldValue.matches(fieldConfig.getRegex());
    }
}
