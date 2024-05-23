package org.ls.lawhelper.validator.validators;

import org.ls.lawhelper.config.AppException;
import org.ls.lawhelper.data.enums.Errors;
import org.ls.lawhelper.data.enums.HttpErrors;

public class EmptyValidator {
    public static <T> void isValid(T field, String fieldName) {
        if (field == null || (field instanceof String && ((String) field).isEmpty())) {
            throw new AppException(HttpErrors.UNPROCESSABLE_CONTENT.getCode(), Errors.EMPTY_OR_NULL_FIELD.getCode(), Errors.EMPTY_OR_NULL_FIELD.getMessage(fieldName));
        }
    }
}
