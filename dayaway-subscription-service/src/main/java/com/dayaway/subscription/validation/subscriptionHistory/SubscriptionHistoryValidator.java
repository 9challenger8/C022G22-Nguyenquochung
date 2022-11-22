package com.dayaway.subscription.validation.subscriptionHistory;

import com.dayaway.subscription.core.validation.AValidator;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.IValidationField;
import com.dayaway.subscription.core.validation.ValidationNullObject;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryInput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubscriptionHistoryValidator extends AValidator<SubscriptionHistoryInput> {
    @Override
    public List<IValidationField<?>> validationList(SubscriptionHistoryInput input, ActionTypeEnum actionType) {
        List<IValidationField<?>> resultList = new ArrayList<>();
        resultList.add(new ValidationNullObject(input, SubscriptionHistoryValidationMessage.NULL_INPUT));
        switch (actionType) {
            case CREATE:
                // resultList.add( new ValidationNullObject( input.getType() , PackageValidationMessage.NULL_TYPE));
                resultList.add(new ValidationNullObject(input.getSubscriptionId(), SubscriptionHistoryValidationMessage.REQUIRE_SUBSCRIPTION_ID));
                resultList.add(new ValidationNullObject(input.getPaymentAmount(), SubscriptionHistoryValidationMessage.REQUIRE_PAYMENT_AMOUNT));
                resultList.add(new ValidationNullObject(input.getPaymentDate(), SubscriptionHistoryValidationMessage.REQUIRE_PAYMENT_DATE));

                break;
            case UPDATE:
                resultList.add(new ValidationNullObject(input.getId(), SubscriptionHistoryValidationMessage.REQUIRE_SUBSCRIPTION_HISTORY_ID));
                break;
            case DELETE:
                resultList.add(new ValidationNullObject(input.getId(), SubscriptionHistoryValidationMessage.REQUIRE_SUBSCRIPTION_HISTORY_ID));
                break;
        }
        return resultList;
    }
}
