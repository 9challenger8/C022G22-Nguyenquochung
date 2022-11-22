package com.dayaway.subscription.service.subscriptionHistory;

import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryDto;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryFilter;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryInput;

public interface SubscriptionHistoryService {
    ResponseData<SubscriptionHistoryDto> subscriptionHistoryList(SubscriptionHistoryFilter filter);

    ResponseContent<SubscriptionHistoryDto> updateSubscriptionHistory(SubscriptionHistoryInput input);

    ResponseContent<SubscriptionHistoryDto> deleteSubscriptionHistory(SubscriptionHistoryInput input);

    ResponseContent<SubscriptionHistoryDto> createSubscriptionHistory(SubscriptionHistoryInput input);
}
