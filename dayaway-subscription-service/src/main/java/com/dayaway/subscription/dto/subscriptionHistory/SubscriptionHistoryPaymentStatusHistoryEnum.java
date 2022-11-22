package com.dayaway.subscription.dto.subscriptionHistory;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;

public enum SubscriptionHistoryPaymentStatusHistoryEnum {
    CANCEL_PAYMENT,
    PAYMENT_AUTHORIZED,
    PAYMENT_FAILED,
    PAYMENT_SUCCEEDED,
    PENDING_PAYMENT;

    @DbEnumValue(storage = DbEnumType.VARCHAR)
    public String getValue() {
        return this.name();
    }
}
