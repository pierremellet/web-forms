package webforms.server.fields.plugins.inputTextArea;

import webforms.server.fields.api.ConfigurableFieldPlugin;
import org.springframework.stereotype.Component;

@Component
public class InputTextArea implements ConfigurableFieldPlugin<String, InputTextAreaConfig> {
    @Override
    public String getTypeName() {
        return "INPUT_TEXTAREA";
    }

    @Override
    public boolean isConfigValid(InputTextAreaConfig fieldPluginConfig) {
        return !fieldPluginConfig.getRegex().isEmpty();
    }

    @Override
    public boolean isValueValid(String fieldValue, InputTextAreaConfig fieldConfig) {
        return fieldValue.matches(fieldConfig.getRegex());
    }
}
