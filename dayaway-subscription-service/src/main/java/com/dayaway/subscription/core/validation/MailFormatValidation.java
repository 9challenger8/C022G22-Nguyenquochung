package com.dayaway.subscription.core.validation;


public class MailFormatValidation extends IValidationField<String> {
    private final String mailFormat = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public MailFormatValidation(String mail, Enum<?> validationMessage) {
        super(mail, validationMessage);
    }

    @Override
    public ValidationMessage validateField() {

        boolean isRightFormat = false;
        if (field != null) {
            isRightFormat = field.matches(mailFormat);
        }
        ValidationMessage result = new ValidationMessage(validationMessage);
        result.setSuccess(isRightFormat);
        return result;
    }
}
