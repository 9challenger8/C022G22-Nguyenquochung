package com.dayaway.subscription.controller;

import com.dayaway.subscription.core.common.BaseController;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryDto;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryFilter;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryInput;
import com.dayaway.subscription.service.subscriptionHistory.SubscriptionHistoryService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class SubscriptionHistoryController extends BaseController {

    @Autowired
    private SubscriptionHistoryService service;

    @QueryMapping
    public ResponseData<SubscriptionHistoryDto> subscriptionHistoryList(DataFetchingEnvironment env) {
        SubscriptionHistoryFilter filter = mapEnv2Filter(env, SubscriptionHistoryFilter.class);
        return service.subscriptionHistoryList(filter);
    }

    @MutationMapping
    public ResponseContent<SubscriptionHistoryDto> updateSubscriptionHistory(DataFetchingEnvironment env) {
        SubscriptionHistoryInput input = mapEnv2Input(env, SubscriptionHistoryInput.class);
        return service.updateSubscriptionHistory(input);
    }

    @MutationMapping
    public ResponseContent<SubscriptionHistoryDto> deleteSubscriptionHistory(DataFetchingEnvironment env) {
        SubscriptionHistoryInput input = mapEnv2Input(env, SubscriptionHistoryInput.class);
        return service.deleteSubscriptionHistory(input);
    }

    @MutationMapping
    public ResponseContent<SubscriptionHistoryDto> createSubscriptionHistory(DataFetchingEnvironment env) {
        SubscriptionHistoryInput input = mapEnv2Input(env, SubscriptionHistoryInput.class);
        return service.createSubscriptionHistory(input);
    }

}