package webforms.server.fields.plugins.inputAddress;

import webforms.server.fields.api.SimpleFieldPlugin;
import org.springframework.stereotype.Component;

@Component
public class InputAddress implements SimpleFieldPlugin<String> {
    @Override
    public String getTypeName() {
        return "INPUT_ADDRESS";
    }

    @Override
    public boolean isValueValid(String fieldValue) {
        return fieldValue != null;
    }
}
