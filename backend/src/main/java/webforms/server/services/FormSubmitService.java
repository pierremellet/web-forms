package webforms.server.services;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webforms.server.api.FormSubmitApiDelegate;
import webforms.server.model.FormConfig;
import webforms.server.model.FormSubmit;
import webforms.server.repositories.FormConfigRepository;
import webforms.server.routers.RouterConfig;
import webforms.server.routers.RouterException;
import webforms.server.routers.RouterManager;
import webforms.server.routers.RouterPlugin;

import java.util.Optional;

@Service
public class FormSubmitService implements FormSubmitApiDelegate {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FormSubmitService.class);

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
            var routerConfig = this.modelMapper.map(formConfig.getRouter().getRouterConfig(), router.get().getConfigClass());
            try {
                router.get().route(formSubmit.getFormId(), formConfig, (RouterConfig) routerConfig, formSubmit.getValues());
            } catch (RouterException e) {
                throw new RuntimeException(e);
            }finally {
                LOGGER.info("Result for form {} submited", formConfig.getFormId());
            }
            return ResponseEntity.ok(formSubmit);
        }else{
            return ResponseEntity.status(500).build();
        }

    }
}
