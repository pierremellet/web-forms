package ff.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import javax.annotation.Generated;

@RestController

public class FormConfigsApiController implements FormConfigsApi {

    private final FormConfigsApiDelegate delegate;

    public FormConfigsApiController(@Autowired(required = false) FormConfigsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FormConfigsApiDelegate() {});
    }

    @Override
    public FormConfigsApiDelegate getDelegate() {
        return delegate;
    }

}
