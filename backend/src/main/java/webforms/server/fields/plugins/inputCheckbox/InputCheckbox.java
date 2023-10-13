package webforms.server.fields.plugins.inputCheckbox;

import org.springframework.stereotype.Component;
import webforms.server.fields.api.SimpleFieldPlugin;

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
