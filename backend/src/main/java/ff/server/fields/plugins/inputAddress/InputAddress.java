package ff.server.fields.plugins.inputAddress;

import ff.server.fields.api.SimpleFieldPlugin;
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
