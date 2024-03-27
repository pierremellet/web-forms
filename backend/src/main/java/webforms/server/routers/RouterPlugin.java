package webforms.server.routers;

import webforms.server.model.FormConfig;
import webforms.server.model.FormValue;

import java.util.List;

public interface RouterPlugin<C extends RouterConfig> {

    String getRouterName();
    boolean isConfigValid(C routerConfig);
    void route(String formId, FormConfig formConfig, C routerConfig, List<FormValue> values) throws RouterException;

    Class<?> getConfigClass();
}
