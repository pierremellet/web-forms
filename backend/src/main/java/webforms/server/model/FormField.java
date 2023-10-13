package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import webforms.server.fields.FieldsManager;

/**
 * FormField
 */

public class FormField {

    private String id;

    private String type;

    private Boolean required;

    private Condition display;

    private I18NString description;

    private I18NString label;


    private Object config;

    public FormField() {
    }

    public FormField(String id, String type, Boolean required, Condition display, I18NString description, I18NString label, Object config) {
        this.id = id;
        this.type = type;
        this.required = required;
        this.display = display;
        this.description = description;
        this.label = label;
        this.config = config;
    }

    @JsonIgnore
    public <T> T castConfig(ObjectMapper objectMapper, Class<T> fieldConfigType) throws JsonProcessingException {
        final String configStr = objectMapper.writeValueAsString(getConfig());
        return objectMapper.readValue(configStr, fieldConfigType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Condition getDisplay() {
        return display;
    }

    public void setDisplay(Condition display) {
        this.display = display;
    }

    public I18NString getDescription() {
        return description;
    }

    public void setDescription(I18NString description) {
        this.description = description;
    }

    public I18NString getLabel() {
        return label;
    }

    public void setLabel(I18NString label) {
        this.label = label;
    }

    public Object getConfig() {
        return config;
    }

    public void setConfig(Object config) {
        this.config = config;
    }

}

