package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FormSection
 */

public class FormSection {

    private String id;

    private I18NString name;

    private I18NString description;

    @Valid
    private List<@Valid FormField> fields;

    /**
     * Default constructor
     *
     * @deprecated Use {@link FormSection#FormSection(String, I18NString)}
     */
    @Deprecated
    public FormSection() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public FormSection(String id, I18NString name) {
        this.id = id;
        this.name = name;
    }

    public FormSection id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @NotNull
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FormSection name(I18NString name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @NotNull
    @Valid
    @JsonProperty("name")
    public I18NString getName() {
        return name;
    }

    public void setName(I18NString name) {
        this.name = name;
    }

    public FormSection description(I18NString description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @Valid
    @JsonProperty("description")
    public I18NString getDescription() {
        return description;
    }

    public void setDescription(I18NString description) {
        this.description = description;
    }

    public FormSection fields(List<@Valid FormField> fields) {
        this.fields = fields;
        return this;
    }

    public FormSection addFieldsItem(FormField fieldsItem) {
        if (this.fields == null) {
            this.fields = new ArrayList<>();
        }
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * Get fields
     *
     * @return fields
     */
    @Valid
    @JsonProperty("fields")
    public List<@Valid FormField> getFields() {
        return fields;
    }

    public void setFields(List<@Valid FormField> fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormSection formSection = (FormSection) o;
        return Objects.equals(this.id, formSection.id) &&
                Objects.equals(this.name, formSection.name) &&
                Objects.equals(this.description, formSection.description) &&
                Objects.equals(this.fields, formSection.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, fields);
    }

    @Override
    public String toString() {
        String sb = "class FormSection {\n" +
                "    id: " + toIndentedString(id) + "\n" +
                "    name: " + toIndentedString(name) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    fields: " + toIndentedString(fields) + "\n" +
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

