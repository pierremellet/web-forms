package ff.server.fields.plugins.inputDate;


import ff.server.model.FormFieldConfig;
import io.swagger.v3.oas.annotations.media.Schema;

public class InputDateConfig extends FormFieldConfig {
    @Schema(description = "regex que la date doit respecter")

    private String regex;


    public InputDateConfig() {
    }

    public InputDateConfig(String regex) {
        this.regex = regex;
     }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
