package com.dayaway.subscription.dto.subscription;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

public enum SubscriptionRelatedTypeEnum {
    CUSTOMER,
    PARTNER;

    @DbEnumValue(storage = DbEnumType.VARCHAR)
    public String getValue() {
        return this.name();
    }
}
