package webforms.server.fields.plugins.inputText;


import io.swagger.v3.oas.annotations.media.Schema;
import webforms.server.model.FormFieldConfig;

public class InputTextConfig implements FormFieldConfig {
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
