/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package webforms.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webforms.server.model.FormFieldValidation;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-30T08:28:17.528094700+02:00[Europe/Paris]")
@Validated
public interface ValidateApi {

    default ValidateApiDelegate getDelegate() {
        return new ValidateApiDelegate() {
        };
    }

    /**
     * POST /validate
     *
     * @param fieldValidation Request validation for field value (optional)
     * @return Request created (status code 201)
     */

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/validate",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    default ResponseEntity<FormFieldValidation> validateField(@Valid @RequestBody(required = false) FormFieldValidation fieldValidation
    ) throws Exception {
        return getDelegate().validateField(fieldValidation);
    }

}
