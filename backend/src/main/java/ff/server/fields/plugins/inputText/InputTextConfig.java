package ff.server.fields.plugins.inputText;


import ff.server.model.FormFieldConfig;
import io.swagger.v3.oas.annotations.media.Schema;

public class InputTextConfig extends FormFieldConfig {
    @Schema(description = "Regex that value must match")

    private String regex;


    public InputTextConfig() {
    }

    public InputTextConfig(String regex) {
        this.regex = regex;
     }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
