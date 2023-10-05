package ff.server.fields.api;

public interface SimpleFieldPlugin<V> extends FieldPlugin {

    boolean isValueValid(V fieldValue);

}
