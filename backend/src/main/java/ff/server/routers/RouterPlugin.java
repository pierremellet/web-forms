package ff.server.routers;

import ff.server.model.FormConfig;
import ff.server.model.FormValue;

import java.util.List;

public interface RouterPlugin<C extends RouterConfig> {

    String getRouterName();

    boolean isConfigValid(C routerConfig);

    void route(String formId, FormConfig formConfig, C routerConfig, List<FormValue> values) throws RouterException;

}
