package com.dayaway.subscription.dto.plan;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

public enum PlanStatusEnum {
    ACTIVE,
    INACTIVE,
    DRAFT;;

    @DbEnumValue(storage = DbEnumType.VARCHAR)
    public String getValue() {
        return this.name();
    }
}
