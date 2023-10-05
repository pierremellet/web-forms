package ff.server.fields.plugins.inputAddress;


import ff.server.model.FormFieldConfig;
import io.swagger.v3.oas.annotations.media.Schema;

public class InputAddressConfig extends FormFieldConfig {

    @Schema(description = "Description de la propriété 1")

    private String min;
    @Schema(description = "Description de la propriété 1")

    private Boolean cp;
    @Schema(description = "Description de la propriété 1")

    private Integer max;


    public InputAddressConfig() {
    }

    public InputAddressConfig(String min, Boolean cp, Integer max) {
        this.min = min;
        this.cp = cp;
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public Boolean getCp() {
        return cp;
    }

    public void setCp(Boolean cp) {
        this.cp = cp;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
