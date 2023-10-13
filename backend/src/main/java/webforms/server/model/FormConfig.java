package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FormConfig
 */

public class FormConfig {

    private String formId;

    private Boolean authentication = false;

    private String customCSS;

    private I18NString description;

    private I18NString name;

    @Valid
    private List<@Valid FormSection> sections = new ArrayList<>();

    private String accountId;

    private String createdDate;

    private String redirectURL;

    private Router router;

    /**
     * Default constructor
     *
     * @deprecated Use {@link FormConfig#FormConfig(I18NString, I18NString, List<@Valid FormSection>)}
     */
    @Deprecated
    public FormConfig() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public FormConfig(I18NString description, I18NString name, List<@Valid FormSection> sections) {
        this.description = description;
        this.name = name;
        this.sections = sections;
    }

    public FormConfig formId(String formId) {
        this.formId = formId;
        return this;
    }

    /**
     * Get formId
     *
     * @return formId
     */

    @JsonProperty("formId")
    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public FormConfig authentication(Boolean authentication) {
        this.authentication = authentication;
        return this;
    }

    /**
     * if true, user authentication is required before fill the form
     *
     * @return authentication
     */

    @JsonProperty("authentication")
    public Boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Boolean authentication) {
        this.authentication = authentication;
    }

    public FormConfig description(I18NString description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @NotNull
    @Valid
    @JsonProperty("description")
    public I18NString getDescription() {
        return description;
    }

    public void setDescription(I18NString description) {
        this.description = description;
    }

    public FormConfig name(I18NString name) {
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

    public FormConfig sections(List<@Valid FormSection> sections) {
        this.sections = sections;
        return this;
    }

    public FormConfig addSectionsItem(FormSection sectionsItem) {
        if (this.sections == null) {
            this.sections = new ArrayList<>();
        }
        this.sections.add(sectionsItem);
        return this;
    }

    public String getCustomCSS() {
        return customCSS;
    }

    public void setCustomCSS(String customCSS) {
        this.customCSS = customCSS;
    }

    /**
     * Get sections
     *
     * @return sections
     */
    @NotNull
    @Valid
    @JsonProperty("sections")
    public List<@Valid FormSection> getSections() {
        return sections;
    }

    public void setSections(List<@Valid FormSection> sections) {
        this.sections = sections;
    }

    public FormConfig accountId(String accountId) {
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

    public FormConfig createdDate(String createdDate) {
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

    public FormConfig redirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
        return this;
    }

    /**
     * URL to redirect user after form completed
     *
     * @return redirectURL
     */

    @JsonProperty("redirectURL")
    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public FormConfig router(Router router) {
        this.router = router;
        return this;
    }

    /**
     * Get router
     *
     * @return router
     */
    @Valid
    @JsonProperty("router")
    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormConfig formConfig = (FormConfig) o;
        return Objects.equals(this.formId, formConfig.formId) &&
                Objects.equals(this.authentication, formConfig.authentication) &&
                Objects.equals(this.description, formConfig.description) &&
                Objects.equals(this.name, formConfig.name) &&
                Objects.equals(this.sections, formConfig.sections) &&
                Objects.equals(this.accountId, formConfig.accountId) &&
                Objects.equals(this.createdDate, formConfig.createdDate) &&
                Objects.equals(this.redirectURL, formConfig.redirectURL) &&
                Objects.equals(this.router, formConfig.router);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId, authentication, description, name, sections, accountId, createdDate, redirectURL, router);
    }

    @Override
    public String toString() {
        String sb = "class FormConfig {\n" +
                "    formId: " + toIndentedString(formId) + "\n" +
                "    authentication: " + toIndentedString(authentication) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    name: " + toIndentedString(name) + "\n" +
                "    sections: " + toIndentedString(sections) + "\n" +
                "    accountId: " + toIndentedString(accountId) + "\n" +
                "    createdDate: " + toIndentedString(createdDate) + "\n" +
                "    redirectURL: " + toIndentedString(redirectURL) + "\n" +
                "    router: " + toIndentedString(router) + "\n" +
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

