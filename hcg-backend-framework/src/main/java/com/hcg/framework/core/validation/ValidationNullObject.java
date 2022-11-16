package com.hcg.framework.core.validation;


public class ValidationNullObject<T> extends IValidationField {
    public ValidationNullObject(T field, Enum<?> validationMessage) {
        super(field, validationMessage);
    }

    @Override
    public ValidationMessage validateField() {
        ValidationMessage result = new ValidationMessage();
        boolean isSuccess = true;
        if (field == null) {
            result.setMessage(validationMessage);
            isSuccess = false;
        }
        result.setSuccess(isSuccess);
        return result;
    }
}
