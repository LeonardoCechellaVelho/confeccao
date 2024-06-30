package org.ls.confeccao.data.enums;

import lombok.Getter;

@Getter
public enum Errors {
    PRODUCT_NOT_FOUND("101","Product not found"),
    PRODUCT_ALREADY_REGISTERED("102","Product already registered"),
    PRODUCTS_NOT_FOUND("103","There are no products registered"),
    EMPTY_OR_NULL_FIELD("1000", "%s cannot be null or empty");

    
    private final String code;
    private final String message;

    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(String fieldName) {
        if (this == EMPTY_OR_NULL_FIELD) {
            return String.format(message, fieldName);
        }
        return message;
    }
}
