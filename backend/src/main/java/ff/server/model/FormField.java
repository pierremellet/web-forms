package ff.server.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FormField
 */

public class FormField {

  private String id;

  private String type;

  private Boolean required;

  private String display;

  private I18NString description;

  private I18NString label;


  private Object config;

  /**
   * Default constructor
   * @deprecated Use {@link FormField#FormField(String, String, I18NString, I18NString, FormFieldConfig)}
   */
  @Deprecated
  public FormField() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormField(String id, String type, I18NString description, I18NString label, Object config) {
    this.id = id;
    this.type = type;
    this.description = description;
    this.label = label;
    this.config = config;
  }

  public FormField id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
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

  public FormField type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FormField required(Boolean required) {
    this.required = required;
    return this;
  }

  /**
   * Get required
   * @return required
  */
  
  @JsonProperty("required")
  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public FormField display(String display) {
    this.display = display;
    return this;
  }

  /**
   * Expression used to determine if the field should be displayed
   * @return display
  */
  
  @JsonProperty("display")
  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public FormField description(I18NString description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @NotNull @Valid 
  @JsonProperty("description")
  public I18NString getDescription() {
    return description;
  }

  public void setDescription(I18NString description) {
    this.description = description;
  }

  public FormField label(I18NString label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  */
  @NotNull @Valid 
  @JsonProperty("label")
  public I18NString getLabel() {
    return label;
  }

  public void setLabel(I18NString label) {
    this.label = label;
  }

  public Object config(Object config) {
    this.config = config;
    return this;
  }

  /**
   * Get config
   * @return config
  */
  @JsonProperty("config")
  public Object getConfig() {
    return config;
  }

  public void setConfig(Object config) {
    this.config = config;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormField formField = (FormField) o;
    return Objects.equals(this.id, formField.id) &&
        Objects.equals(this.type, formField.type) &&
        Objects.equals(this.required, formField.required) &&
        Objects.equals(this.display, formField.display) &&
        Objects.equals(this.description, formField.description) &&
        Objects.equals(this.label, formField.label) &&
        Objects.equals(this.config, formField.config);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, required, display, description, label, config);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormField {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("}");
    return sb.toString();
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

