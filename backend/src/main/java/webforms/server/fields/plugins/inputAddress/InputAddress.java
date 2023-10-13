package webforms.server.fields.plugins.inputAddress;

import org.springframework.stereotype.Component;
import webforms.server.fields.api.SimpleFieldPlugin;

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
