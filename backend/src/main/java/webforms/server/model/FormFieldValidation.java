package webforms.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

/**
 * FieldValidation
 */

public class FormFieldValidation {

  private String fieldId;

  private String formId;

  private Object fieldValue;

  private Boolean valide;

  /**
   * Default constructor
   * @deprecated Use {@link FormFieldValidation#FormFieldValidation(String, String, Object)}
   */
  @Deprecated
  public FormFieldValidation() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormFieldValidation(String fieldId, String formId, Object fieldValue) {
    this.fieldId = fieldId;
    this.formId = formId;
    this.fieldValue = fieldValue;
  }

  public FormFieldValidation fieldId(String fieldId) {
    this.fieldId = fieldId;
    return this;
  }

  /**
   * Get fieldId
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

  public FormFieldValidation formId(String formId) {
    this.formId = formId;
    return this;
  }

  /**
   * Get formId
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

  public FormFieldValidation fieldValue(Object fieldValue) {
    this.fieldValue = fieldValue;
    return this;
  }

  /**
   * Get fieldValue
   * @return fieldValue
  */
  @NotNull 
  @JsonProperty("fieldValue")
  public Object getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(Object fieldValue) {
    this.fieldValue = fieldValue;
  }

  public FormFieldValidation valide(Boolean valide) {
    this.valide = valide;
    return this;
  }

  /**
   * Get valide
   * @return valide
  */
  
  @JsonProperty("valide")
  public Boolean getValide() {
    return valide;
  }

  public void setValide(Boolean valide) {
    this.valide = valide;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormFieldValidation fieldValidation = (FormFieldValidation) o;
    return Objects.equals(this.fieldId, fieldValidation.fieldId) &&
        Objects.equals(this.formId, fieldValidation.formId) &&
        Objects.equals(this.fieldValue, fieldValidation.fieldValue) &&
        Objects.equals(this.valide, fieldValidation.valide);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldId, formId, fieldValue, valide);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldValidation {\n");
    sb.append("    fieldId: ").append(toIndentedString(fieldId)).append("\n");
    sb.append("    formId: ").append(toIndentedString(formId)).append("\n");
    sb.append("    fieldValue: ").append(toIndentedString(fieldValue)).append("\n");
    sb.append("    valide: ").append(toIndentedString(valide)).append("\n");
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

