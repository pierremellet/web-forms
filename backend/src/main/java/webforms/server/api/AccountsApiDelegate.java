package webforms.server.api;

import webforms.server.model.Account;
import webforms.server.model.CreateAccountRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link AccountsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
public interface AccountsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /accounts : Create a account
     *
     * @param createAccountRequest Request Configuraiton (optional)
     * @return Requestion created (status code 201)
     * @see AccountsApi#createAccount
     */
    default ResponseEntity<Account> createAccount(CreateAccountRequest createAccountRequest) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /accounts : Create a account
     *
     * @return Requestion created (status code 200)
     * @see AccountsApi#listAccounts
     */
    default ResponseEntity<List<Account>> listAccounts() throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
