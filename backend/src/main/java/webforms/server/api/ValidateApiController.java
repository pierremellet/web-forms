package webforms.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class ValidateApiController implements ValidateApi {

    private final ValidateApiDelegate delegate;

    public ValidateApiController(@Autowired(required = false) ValidateApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ValidateApiDelegate() {
        });
    }

    @Override
    public ValidateApiDelegate getDelegate() {
        return delegate;
    }

}
