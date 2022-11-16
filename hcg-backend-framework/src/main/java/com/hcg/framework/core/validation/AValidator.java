package com.hcg.framework.core.validation;


import java.util.List;

public abstract class AValidator<T> {
    public ValidationMessage validateEntity(T input, ActionTypeEnum actionType) {
        ValidationMessage rs = new ValidationMessage();
        boolean success = true;


        // Get list validation by action type
        List<IValidationField<?>> validationList = this.validationList(input, actionType);
        if (validationList != null )
            for (IValidationField<?> validationField : validationList) {
                rs = validationField.validateField();
                if (!rs.getSuccess()) {
                    success = rs.getSuccess();
                    break;
                }
            }

        rs.setSuccess(success);
        return rs;
    }

    abstract public List<IValidationField<?>> validationList(T input, ActionTypeEnum actionType);
}
