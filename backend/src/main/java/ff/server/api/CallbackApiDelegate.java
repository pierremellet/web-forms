package ff.server.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link CallbackApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-30T08:28:17.528094700+02:00[Europe/Paris]")
public interface CallbackApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /callback
     *
     * @param code  (optional)
     * @param state  (optional)
     * @return  (status code 200)
     * @see CallbackApi#oAuth2Callback
     */
    default ResponseEntity<String> oAuth2Callback(String code,
        String state) throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
