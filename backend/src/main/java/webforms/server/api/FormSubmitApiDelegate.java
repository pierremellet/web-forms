package webforms.server.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import webforms.server.model.FormSubmit;

import javax.annotation.Generated;
import java.util.Optional;

/**
 * A delegate to be called by the {@link FormSubmitApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-30T08:28:17.528094700+02:00[Europe/Paris]")
public interface FormSubmitApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /formSubmit
     *
     * @param formSubmit Submitted Form content (optional)
     * @return form submitted (status code 201)
     * @see FormSubmitApi#submitForm
     */
    default ResponseEntity<FormSubmit> submitForm(FormSubmit formSubmit) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
