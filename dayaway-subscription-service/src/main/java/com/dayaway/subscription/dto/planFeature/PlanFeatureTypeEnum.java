package com.dayaway.subscription.dto.planFeature;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

public enum PlanFeatureTypeEnum {
    CUSTOMER,
    PARTNER,
    ;

    @DbEnumValue(storage = DbEnumType.VARCHAR)
    public String getValue() {
        return this.name();
    }

}
