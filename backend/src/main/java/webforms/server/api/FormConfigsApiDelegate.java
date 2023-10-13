package webforms.server.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import webforms.server.model.FormConfig;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link FormConfigsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-30T08:28:17.528094700+02:00[Europe/Paris]")
public interface FormConfigsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /formConfigs : Create or update a form
     *
     * @param formConfig Request Configuraiton (optional)
     * @return Requestion created (status code 201)
     * @see FormConfigsApi#createOrUpdateForm
     */
    default ResponseEntity<FormConfig> createOrUpdateForm(FormConfig formConfig) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /formConfigs/{formId} : Get a form configuration by formId
     *
     * @param formId Numeric ID of the form config to get (required)
     * @return form configuration (status code 200)
     * @see FormConfigsApi#getFormConfig
     */
    default ResponseEntity<FormConfig> getFormConfig(String formId) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /formConfigs : Get all form configuration instances
     *
     * @return List of form configs (status code 200)
     * @see FormConfigsApi#listForms
     */
    default ResponseEntity<List<FormConfig>> listForms() throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
