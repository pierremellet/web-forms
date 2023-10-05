package ff.server.fields.plugins.inputSelectMono;


import ff.server.model.FormFieldConfig;
import ff.server.model.I18NString;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

public class InputSelectMonoConfig extends FormFieldConfig {
    @Schema(description = "Selectable options")

    private Map<String, I18NString> options;

    public InputSelectMonoConfig() {
    }

    public InputSelectMonoConfig(Map<String, I18NString> options) {
        this.options = options;
    }

    public Map<String, I18NString> getOptions() {
        return options;
    }

    public void setOptions(Map<String, I18NString> options) {
        this.options = options;
    }
}
