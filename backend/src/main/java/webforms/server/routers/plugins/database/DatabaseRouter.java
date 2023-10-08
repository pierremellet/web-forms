package webforms.server.routers.plugins.database;

import webforms.server.model.FormConfig;
import webforms.server.model.FormValue;
import webforms.server.routers.RouterException;
import webforms.server.routers.RouterPlugin;
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
