package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * FormError
 */

public class FormError {

    private String id;

    private String message;

    public FormError id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FormError message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     */

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormError formError = (FormError) o;
        return Objects.equals(this.id, formError.id) &&
                Objects.equals(this.message, formError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    @Override
    public String toString() {
        String sb = "class FormError {\n" +
                "    id: " + toIndentedString(id) + "\n" +
                "    message: " + toIndentedString(message) + "\n" +
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

