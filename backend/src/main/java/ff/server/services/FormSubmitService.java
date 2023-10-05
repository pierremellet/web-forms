package ff.server.services;

import ff.server.api.FormSubmitApiDelegate;
import ff.server.model.FormConfig;
import ff.server.model.FormSubmit;
import ff.server.repositories.FormConfigRepository;
import ff.server.routers.RouterConfig;
import ff.server.routers.RouterException;
import ff.server.routers.RouterManager;
import ff.server.routers.RouterPlugin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormSubmitService implements FormSubmitApiDelegate {

    @Autowired
    private FormConfigRepository formConfigRepository;

    @Autowired
    private RouterManager routerManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<FormSubmit> submitForm(FormSubmit formSubmit) {

        final FormConfig formConfig = this.formConfigRepository.findByFormId(formSubmit.getFormId());

        final Optional<RouterPlugin> router = this.routerManager.getRouter(formConfig.getRouter());

        if (router.isPresent()) {
            RouterConfig routerConfig = this.modelMapper.map(formConfig.getRouter().getRouterConfig(), RouterConfig.class);
            try {
                router.get().route(formSubmit.getFormId(), formConfig, routerConfig, formSubmit.getValues());
            } catch (RouterException e) {
                throw new RuntimeException(e);
            }
        } else {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(formSubmit);
    }
}
