package ff.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import javax.annotation.Generated;

@RestController

public class FormResultsApiController implements FormResultsApi {

    private final FormResultsApiDelegate delegate;

    public FormResultsApiController(@Autowired(required = false) FormResultsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FormResultsApiDelegate() {});
    }

    @Override
    public FormResultsApiDelegate getDelegate() {
        return delegate;
    }

}
