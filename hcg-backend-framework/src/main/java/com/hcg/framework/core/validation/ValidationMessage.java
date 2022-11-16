package com.hcg.framework.core.validation;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ValidationMessage implements Serializable {
    private static final long serialVersionUID = -5506334162669252622L;
    private String code;
    private String message;
    private Boolean success;

    public ValidationMessage(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ValidationMessage(Enum<?> enumMessage) {
        super();
        this.code = enumMessage.toString();
        this.message = enumMessage.name();
    }

    public void setMessage(Enum<?> enumMessage) {
        this.code = enumMessage.toString();
        this.message = enumMessage.name();
    }
}
