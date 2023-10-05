package ff.server.services;

import ff.server.model.FormError;

import java.util.List;

public record FormConfigValidation(List<FormError> fieldErrors,
                                   List<FormError> routerError,
                                   List<FormError> sectionIdsError,
                                   List<FormError> fieldIdsError,
                                   List<FormError> fieldDisplayError,
                                   List<FormError> fieldConfigurationError) {

    boolean hasError() {
        return !(this.fieldErrors.isEmpty()
                && this.routerError.isEmpty()
                && this.sectionIdsError.isEmpty()
                && this.fieldIdsError.isEmpty()
                && this.fieldDisplayError.isEmpty()
                && this.fieldConfigurationError.isEmpty());
    }

}
