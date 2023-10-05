package ff.server.fields.plugins.inputCheckbox;

import ff.server.fields.api.ConfigurableFieldPlugin;
import ff.server.fields.api.SimpleFieldPlugin;
import org.springframework.stereotype.Component;

@Component
public class InputCheckbox implements SimpleFieldPlugin<String> {
    @Override
    public String getTypeName() {
        return "INPUT_CHECKBOX";
    }


    @Override
    public boolean isValueValid(String fieldValue) {
        return true;
    }
}
