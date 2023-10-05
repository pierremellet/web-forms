package ff.server.routers.plugins.database;

import ff.server.model.FormConfig;
import ff.server.model.FormValue;
import ff.server.routers.RouterException;
import ff.server.routers.RouterPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DatabaseRouter implements RouterPlugin<DatabaseRouterConfig> {

    @Autowired
    private FormSubmitRepository formSubmitRepository;

    @Override
    public String getRouterName() {
        return "DATABASE_ROUTER";
    }

    @Override
    public boolean isConfigValid(DatabaseRouterConfig routerConfig) {
        return true;
    }

    @Override
    public void route(String formId, FormConfig formConfig, DatabaseRouterConfig routerConfig, List<FormValue> values) throws RouterException {
        final FormSubmitDocument formSubmitDocument = new FormSubmitDocument();
        formSubmitDocument.setFormId(formId);
        formSubmitDocument.setCreatedDate((new Date()).toString());
        formSubmitDocument.setValues(values);
        this.formSubmitRepository.insert(formSubmitDocument);
    }
}
