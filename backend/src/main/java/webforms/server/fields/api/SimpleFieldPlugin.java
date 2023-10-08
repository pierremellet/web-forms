package webforms.server.fields.api;

public interface SimpleFieldPlugin<V> extends FieldPlugin {

    boolean isValueValid(V fieldValue);

}
