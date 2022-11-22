package com.dayaway.subscription.core.httpClientRemote;

public enum ClientRemoteEnum {
    PackageModule("package-module"),

    ;

    private final String value;

    public String getValue() {
        return this.value;
    }

    ClientRemoteEnum(String value) {
        this.value = value;
    }
}
