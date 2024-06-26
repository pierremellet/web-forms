/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package webforms.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Validated
public interface CallbackApi {

    default CallbackApiDelegate getDelegate() {
        return new CallbackApiDelegate() {
        };
    }

    /**
     * GET /callback
     *
     * @param code  (optional)
     * @param state (optional)
     * @return (status code 200)
     */

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/callback",
            produces = {"application/json"}
    )
    default ResponseEntity<String> oAuth2Callback(
            @Valid @RequestParam(value = "code", required = false) String code,
            @Valid @RequestParam(value = "state", required = false) String state
    ) throws Exception {
        return getDelegate().oAuth2Callback(code, state);
    }

}
