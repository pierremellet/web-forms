package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FormSubmit
 */

public class FormSubmit {

    private String formId;

    private String createdDate;

    @Valid
    private List<@Valid FormValue> values = new ArrayList<>();

    /**
     * Default constructor
     *
     * @deprecated Use {@link FormSubmit#FormSubmit(String, List<@Valid FormValue>)}
     */
    @Deprecated
    public FormSubmit() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public FormSubmit(String formId, List<@Valid FormValue> values) {
        this.formId = formId;
        this.values = values;
    }

    public FormSubmit formId(String formId) {
        this.formId = formId;
        return this;
    }

    /**
     * Get formId
     *
     * @return formId
     */
    @NotNull
    @JsonProperty("formId")
    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public FormSubmit createdDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     */

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public FormSubmit values(List<@Valid FormValue> values) {
        this.values = values;
        return this;
    }

    public FormSubmit addValuesItem(FormValue valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * Get values
     *
     * @return values
     */
    @NotNull
    @Valid
    @JsonProperty("values")
    public List<@Valid FormValue> getValues() {
        return values;
    }

    public void setValues(List<@Valid FormValue> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormSubmit formSubmit = (FormSubmit) o;
        return Objects.equals(this.formId, formSubmit.formId) &&
                Objects.equals(this.createdDate, formSubmit.createdDate) &&
                Objects.equals(this.values, formSubmit.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId, createdDate, values);
    }

    @Override
    public String toString() {
        String sb = "class FormSubmit {\n" +
                "    formId: " + toIndentedString(formId) + "\n" +
                "    createdDate: " + toIndentedString(createdDate) + "\n" +
                "    values: " + toIndentedString(values) + "\n" +
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

