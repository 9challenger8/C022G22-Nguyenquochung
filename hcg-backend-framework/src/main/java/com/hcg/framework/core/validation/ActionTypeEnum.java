package com.hcg.framework.core.validation;

public enum ActionTypeEnum {
    CREATE,
    UPDATE,
    DELETE,
    CONVERT,
    ;
    public String getValue(){
        return this.name();
    }
}
