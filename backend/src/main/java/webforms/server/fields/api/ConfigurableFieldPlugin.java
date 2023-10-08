package webforms.server.fields.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public interface ConfigurableFieldPlugin<V, C> extends FieldPlugin {

    boolean isConfigValid(C fieldPluginConfig);

    boolean isValueValid(V fieldValue, C fieldPluginConfig);

    default Class<C> getConfigTypeName() {
        Type[] types = ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments();
        if (types.length > 1 && types[1] instanceof Class) {
            return (Class<C>) types[1];
        } else {
            throw new IllegalArgumentException("Unable to determine the type of C.");
        }
    }

    default C instanceFromJSON(ObjectMapper mapper, String jsonString){
        return mapper.convertValue(jsonString, getConfigTypeName());
    }

}
