package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * CreateAccountRequest
 */

public class CreateAccountRequest {

    private String owner;

    /**
     * Default constructor
     *
     * @deprecated Use {@link CreateAccountRequest#CreateAccountRequest(String)}
     */
    @Deprecated
    public CreateAccountRequest() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public CreateAccountRequest(String owner) {
        this.owner = owner;
    }

    public CreateAccountRequest owner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Get owner
     *
     * @return owner
     */
    @NotNull
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateAccountRequest createAccountRequest = (CreateAccountRequest) o;
        return Objects.equals(this.owner, createAccountRequest.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }

    @Override
    public String toString() {
        String sb = "class CreateAccountRequest {\n" +
                "    owner: " + toIndentedString(owner) + "\n" +
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

