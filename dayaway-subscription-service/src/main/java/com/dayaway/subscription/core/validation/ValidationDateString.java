package com.dayaway.subscription.core.validation;


import org.apache.logging.log4j.util.Strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationDateString extends IValidationField<String> {
    public ValidationDateString(String fieldValue, Enum validationMessage) {
        super(fieldValue, validationMessage);
    }

    @Override
    public ValidationMessage validateField() {
        ValidationMessage result = new ValidationMessage();
        boolean isSuccess = true;
        if (!Strings.isEmpty(this.field)) {
            result.setMessage(this.validationMessage);
            isSuccess = false;
        }
        try {
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            formatter1.parse(this.field);

        } catch (ParseException e) {
            result.setMessage(this.validationMessage);
            isSuccess = false;
        }
        result.setSuccess(isSuccess);
        return result;
    }
}
