package com.dayaway.subscription.core.validation;

import org.apache.logging.log4j.util.Strings;

public class ValidationEmptyString extends IValidationField<String> {
    public ValidationEmptyString(String fieldValue, Enum validationMessage) {
        super(fieldValue, validationMessage);
    }

    @Override
    public ValidationMessage validateField() {
        ValidationMessage result = new ValidationMessage();
        boolean isSuccess = true;
        if (Strings.isEmpty(field) || (this.field.trim().length() == 0)) {
            result.setMessage(this.validationMessage);
            isSuccess = false;
        }
        result.setSuccess(isSuccess);
        return result;
    }
}
