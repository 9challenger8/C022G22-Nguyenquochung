package com.dayaway.subscription.dto.subscription;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

public enum SubscriptionStatusEnum {
    ACTIVE,
    INACTIVE,
    PENDING,;

    @DbEnumValue(storage = DbEnumType.VARCHAR)
    public String getValue() { return this.name(); }
}
