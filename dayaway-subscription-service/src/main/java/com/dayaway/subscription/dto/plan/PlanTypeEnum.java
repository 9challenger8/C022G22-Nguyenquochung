package com.dayaway.subscription.dto.plan;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

public enum PlanTypeEnum {
    CUSTOMER,
    PARTNER;;

    @DbEnumValue(storage = DbEnumType.VARCHAR)
    public String getValue() {
        return this.name();
    }
}
