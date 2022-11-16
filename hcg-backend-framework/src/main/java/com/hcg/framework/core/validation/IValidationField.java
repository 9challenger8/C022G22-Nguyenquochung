package com.hcg.framework.core.validation;


public abstract class IValidationField<T> {
    protected T field;

    protected Enum<?> validationMessage;

    public IValidationField(Enum<?> validationMessage) {
        this.validationMessage = validationMessage;
    }


    public IValidationField(T field, Enum<?> validationMessage) {
        this.field = field;
        this.validationMessage = validationMessage;
    }

    abstract public ValidationMessage validateField();
}
