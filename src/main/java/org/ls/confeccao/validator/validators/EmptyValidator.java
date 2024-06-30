package org.ls.confeccao.validator.validators;

import org.ls.confeccao.config.AppException;
import org.ls.confeccao.data.enums.Errors;
import org.ls.confeccao.data.enums.HttpErrors;

public class EmptyValidator {
    public static <T> void isValid(T field, String fieldName) {
        if (field == null || (field instanceof String && ((String) field).isEmpty())) {
            throw new AppException(HttpErrors.UNPROCESSABLE_CONTENT.getCode(), Errors.EMPTY_OR_NULL_FIELD.getCode(), Errors.EMPTY_OR_NULL_FIELD.getMessage(fieldName));
        }
    }
    public static <T> void isValidNullable(T field, String fieldName) {
        if (field != null) {
            if (field instanceof String && ((String) field).isEmpty()) {
                throw new AppException(HttpErrors.UNPROCESSABLE_CONTENT.getCode(), Errors.EMPTY_OR_NULL_FIELD.getCode(), Errors.EMPTY_OR_NULL_FIELD.getMessage(fieldName));
            }
        }
    }
}
