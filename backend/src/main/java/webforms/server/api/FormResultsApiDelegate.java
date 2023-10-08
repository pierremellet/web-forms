package webforms.server.api;

import webforms.server.model.FormValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link FormResultsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-30T08:28:17.528094700+02:00[Europe/Paris]")
public interface FormResultsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /formResults/{formId}
     *
     * @param formId Numeric ID of the form config (required)
     * @return List form respones with router ROUTER_DATABASE class (status code 200)
     * @see FormResultsApi#listFormResults
     */
    default ResponseEntity<List<FormValue>> listFormResults(String formId) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
