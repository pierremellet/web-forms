package ff.server.fields.plugins.inputSelectMono;

import ff.server.fields.api.ConfigurableFieldPlugin;
import org.springframework.stereotype.Component;

@Component
public class InputSelectMono implements ConfigurableFieldPlugin<String, InputSelectMonoConfig> {
    @Override
    public String getTypeName() {
        return "INPUT_SELECTMONO";
    }

    @Override
    public boolean isConfigValid(InputSelectMonoConfig fieldPluginConfig) {
        return !fieldPluginConfig.getOptions().isEmpty();
    }

    @Override
    public boolean isValueValid(String fieldValue, InputSelectMonoConfig fieldConfig) {
        return true;
    }
}
