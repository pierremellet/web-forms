package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * I18NString
 */

public class I18NString {

    @Schema(name = "EN")
    private String EN;

    @Schema(name = "FR")
    private String FR;

    public I18NString EN(String EN) {
        this.EN = EN;
        return this;
    }

    /**
     * Get EN
     *
     * @return EN
     */

    @JsonProperty("EN")
    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }

    public I18NString FR(String FR) {
        this.FR = FR;
        return this;
    }

    /**
     * Get FR
     *
     * @return FR
     */

    @JsonProperty("FR")
    public String getFR() {
        return FR;
    }

    public void setFR(String FR) {
        this.FR = FR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        I18NString i18NString = (I18NString) o;
        return Objects.equals(this.EN, i18NString.EN) &&
                Objects.equals(this.FR, i18NString.FR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EN, FR);
    }

    @Override
    public String toString() {
        String sb = "class I18NString {\n" +
                "    EN: " + toIndentedString(EN) + "\n" +
                "    FR: " + toIndentedString(FR) + "\n" +
                "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

