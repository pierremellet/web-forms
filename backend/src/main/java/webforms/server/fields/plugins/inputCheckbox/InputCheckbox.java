package webforms.server.fields.plugins.inputCheckbox;

import webforms.server.fields.api.SimpleFieldPlugin;
import org.springframework.stereotype.Component;

@Component
public class InputCheckbox implements SimpleFieldPlugin<Boolean> {
    @Override
    public String getTypeName() {
        return "INPUT_CHECKBOX";
    }


    @Override
    public boolean isValueValid(Boolean fieldValue) {
        return true;
    }
}
