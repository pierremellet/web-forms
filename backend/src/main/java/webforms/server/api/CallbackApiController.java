package webforms.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CallbackApiController implements CallbackApi {

    private final CallbackApiDelegate delegate;

    public CallbackApiController(@Autowired(required = false) CallbackApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CallbackApiDelegate() {
        });
    }

    @Override
    public CallbackApiDelegate getDelegate() {
        return delegate;
    }

}
