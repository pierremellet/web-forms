package webforms.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

/**
 * FormRouter
 */

public class FormRouter {

  private String routerId;

  private String subscriptionId;

  private String type;

  private Object config;

  private String createdDate;

  /**
   * Default constructor
   * @deprecated Use {@link FormRouter#FormRouter(String, Object)}
   */
  @Deprecated
  public FormRouter() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormRouter(String type, Object config) {
    this.type = type;
    this.config = config;
  }

  public FormRouter routerId(String routerId) {
    this.routerId = routerId;
    return this;
  }

  /**
   * Get routerId
   * @return routerId
  */
  
  @JsonProperty("routerId")
  public String getRouterId() {
    return routerId;
  }

  public void setRouterId(String routerId) {
    this.routerId = routerId;
  }

  public FormRouter subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * Get subscriptionId
   * @return subscriptionId
  */
  
  @JsonProperty("subscriptionId")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public FormRouter type(String type) {
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

  public FormRouter config(Object config) {
    this.config = config;
    return this;
  }

  /**
   * Get config
   * @return config
  */
  @NotNull 
  @JsonProperty("config")
  public Object getConfig() {
    return config;
  }

  public void setConfig(Object config) {
    this.config = config;
  }

  public FormRouter createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  */
  
  @JsonProperty("createdDate")
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormRouter formRouter = (FormRouter) o;
    return Objects.equals(this.routerId, formRouter.routerId) &&
        Objects.equals(this.subscriptionId, formRouter.subscriptionId) &&
        Objects.equals(this.type, formRouter.type) &&
        Objects.equals(this.config, formRouter.config) &&
        Objects.equals(this.createdDate, formRouter.createdDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routerId, subscriptionId, type, config, createdDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormRouter {\n");
    sb.append("    routerId: ").append(toIndentedString(routerId)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
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

