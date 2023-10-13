package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * FormValue
 */

public class FormValue {

    private String fieldId;

    private String fieldValue;

    /**
     * Default constructor
     *
     * @deprecated Use {@link FormValue#FormValue(String, String)}
     */
    @Deprecated
    public FormValue() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public FormValue(String fieldId, String fieldValue) {
        this.fieldId = fieldId;
        this.fieldValue = fieldValue;
    }

    public FormValue fieldId(String fieldId) {
        this.fieldId = fieldId;
        return this;
    }

    /**
     * Get fieldId
     *
     * @return fieldId
     */
    @NotNull
    @JsonProperty("fieldId")
    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public FormValue fieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
        return this;
    }

    /**
     * Get fieldValue
     *
     * @return fieldValue
     */
    @NotNull
    @JsonProperty("fieldValue")
    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormValue formValue = (FormValue) o;
        return Objects.equals(this.fieldId, formValue.fieldId) &&
                Objects.equals(this.fieldValue, formValue.fieldValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldId, fieldValue);
    }

    @Override
    public String toString() {
        String sb = "class FormValue {\n" +
                "    fieldId: " + toIndentedString(fieldId) + "\n" +
                "    fieldValue: " + toIndentedString(fieldValue) + "\n" +
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

