package ff.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class FormSubmitApiController implements FormSubmitApi {

    private final FormSubmitApiDelegate delegate;

    public FormSubmitApiController(@Autowired(required = false) FormSubmitApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FormSubmitApiDelegate() {});
    }

    @Override
    public FormSubmitApiDelegate getDelegate() {
        return delegate;
    }

}
