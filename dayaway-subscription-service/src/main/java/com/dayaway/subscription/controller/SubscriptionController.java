package com.dayaway.subscription.controller;

import com.dayaway.subscription.core.common.BaseController;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.subscription.SubscriptionDto;
import com.dayaway.subscription.dto.subscription.SubscriptionFilter;
import com.dayaway.subscription.dto.subscription.SubscriptionInput;
import com.dayaway.subscription.service.subscription.SubscriptionService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class SubscriptionController extends BaseController {

    @Autowired
    private SubscriptionService service;

    @QueryMapping
    public ResponseData<SubscriptionDto> subscriptionList(DataFetchingEnvironment env) {
        SubscriptionFilter filter = mapEnv2Filter(env, SubscriptionFilter.class);
        return service.subscriptionList(filter);
    }

    @MutationMapping
    public ResponseContent<SubscriptionDto> updateSubscription(DataFetchingEnvironment env) {
        SubscriptionInput input = mapEnv2Input(env, SubscriptionInput.class);
        return service.updateSubscription(input);
    }

    @MutationMapping
    public ResponseContent<SubscriptionDto> deleteSubscription(DataFetchingEnvironment env) {
        SubscriptionInput input = mapEnv2Input(env, SubscriptionInput.class);
        return service.deleteSubscription(input);
    }

    @MutationMapping
    public ResponseContent<SubscriptionDto> createSubscription(DataFetchingEnvironment env) {
        SubscriptionInput input = mapEnv2Input(env, SubscriptionInput.class);
        return service.createSubscription(input);
    }

}