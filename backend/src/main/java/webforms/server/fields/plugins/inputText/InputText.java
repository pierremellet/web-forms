package webforms.server.fields.plugins.inputText;

import org.springframework.stereotype.Component;
import webforms.server.fields.api.ConfigurableFieldPlugin;

@Component
public class InputText implements ConfigurableFieldPlugin<String, InputTextConfig> {
    @Override
    public String getTypeName() {
        return "INPUT_TEXT";
    }

    @Override
    public boolean isConfigValid(InputTextConfig fieldPluginConfig) {
        return !fieldPluginConfig.getRegex().isEmpty();
    }

    @Override
    public boolean isValueValid(String fieldValue, InputTextConfig fieldConfig) {
        return fieldValue.matches(fieldConfig.getRegex());
    }
}
