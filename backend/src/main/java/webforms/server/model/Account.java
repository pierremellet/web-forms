package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Account
 */

public class Account {

    private String accountId;

    private String owner;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Account#Account(String)}
     */
    @Deprecated
    public Account() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Account(String owner) {
        this.owner = owner;
    }

    public Account accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     */

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Account owner(String owner) {
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
        Account account = (Account) o;
        return Objects.equals(this.accountId, account.accountId) &&
                Objects.equals(this.owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, owner);
    }

    @Override
    public String toString() {
      String sb = "class Account {\n" +
              "    accountId: " + toIndentedString(accountId) + "\n" +
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

