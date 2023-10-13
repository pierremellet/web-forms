package webforms.server.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import webforms.server.model.FormFieldValidation;

import javax.annotation.Generated;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ValidateApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-30T08:28:17.528094700+02:00[Europe/Paris]")
public interface ValidateApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /validate
     *
     * @param fieldValidation Request validation for field value (optional)
     * @return Request created (status code 201)
     * @see ValidateApi#validateField
     */
    default ResponseEntity<FormFieldValidation> validateField(FormFieldValidation fieldValidation) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
