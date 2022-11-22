package com.dayaway.subscription.validation.subscription;


public enum SubscriptionValidationMessage {

    // DEFAULT
    CREATE_SUCCESS("200"),
    UPDATE_SUCCESS("201"),
    DELETE_SUCCESS("202"),


    NULL_INPUT("400"),
    REQUEST_AUTHORIZED("401"),
    NOT_FOUND("402"),

    CREATE_FAIL("900"),
    UPDATE_FAIL("901"),
    DELETE_FAIL("902"),
    ERROR("999"),

    // DEFAULT END

    // ADD BEFORE HERE
    REQUIRE_ID("403"),
    REQUIRE_SUBSCRIPTION_ID("404"),
    REQUIRE_PLAN_ID("405"),
    ;

    private String value;

    SubscriptionValidationMessage(String value) {
        this.value = String.format("%s-%s", SubscriptionValidationMessage.class.getSimpleName(), value);
    }

    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
