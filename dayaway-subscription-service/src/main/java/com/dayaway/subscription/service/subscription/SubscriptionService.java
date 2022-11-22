package com.dayaway.subscription.service.subscription;

import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.subscription.SubscriptionDto;
import com.dayaway.subscription.dto.subscription.SubscriptionFilter;
import com.dayaway.subscription.dto.subscription.SubscriptionInput;

public interface SubscriptionService {
    ResponseData<SubscriptionDto> subscriptionList(SubscriptionFilter filter);

    ResponseContent<SubscriptionDto> updateSubscription(SubscriptionInput input);

    ResponseContent<SubscriptionDto> deleteSubscription(SubscriptionInput input);

    ResponseContent<SubscriptionDto> createSubscription(SubscriptionInput input);
}
