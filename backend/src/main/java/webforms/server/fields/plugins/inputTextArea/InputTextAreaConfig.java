package webforms.server.fields.plugins.inputTextArea;


import io.swagger.v3.oas.annotations.media.Schema;
import webforms.server.model.FormFieldConfig;

public class InputTextAreaConfig implements FormFieldConfig {
    @Schema(description = "Regex that value must match")

    private String regex;


    public InputTextAreaConfig() {
    }

    public InputTextAreaConfig(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
