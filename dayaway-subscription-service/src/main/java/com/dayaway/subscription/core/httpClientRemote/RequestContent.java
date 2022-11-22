package com.dayaway.subscription.core.httpClientRemote;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RequestContent {

    private String operationName;

    private String query;

    private Map<String, Object> variables;

    public RequestContent() {
        super();
    }
}
