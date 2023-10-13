package webforms.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountsApiController implements AccountsApi {

    private final AccountsApiDelegate delegate;

    public AccountsApiController(@Autowired(required = false) AccountsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AccountsApiDelegate() {
        });
    }

    @Override
    public AccountsApiDelegate getDelegate() {
        return delegate;
    }

}
