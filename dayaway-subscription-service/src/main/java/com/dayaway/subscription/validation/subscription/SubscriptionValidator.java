package com.dayaway.subscription.validation.subscription;

import com.dayaway.subscription.core.validation.AValidator;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.IValidationField;
import com.dayaway.subscription.core.validation.ValidationNullObject;
import com.dayaway.subscription.dto.subscription.SubscriptionInput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubscriptionValidator extends AValidator<SubscriptionInput> {
    @Override
    public List<IValidationField<?>> validationList(SubscriptionInput input, ActionTypeEnum actionType) {
        List<IValidationField<?>> resultList = new ArrayList<>();
        resultList.add(new ValidationNullObject(input, SubscriptionValidationMessage.NULL_INPUT));
        switch (actionType) {
            case CREATE:
                // resultList.add( new ValidationNullObject( input.getType() , PackageValidationMessage.NULL_TYPE));

                resultList.add(new ValidationNullObject(input.getPlanId(), SubscriptionValidationMessage.REQUIRE_PLAN_ID));


                break;
            case UPDATE:
                resultList.add(new ValidationNullObject(input.getId(), SubscriptionValidationMessage.REQUIRE_SUBSCRIPTION_ID));
                break;
            case DELETE:
                resultList.add(new ValidationNullObject(input.getId(), SubscriptionValidationMessage.REQUIRE_SUBSCRIPTION_ID));
                break;
        }
        return resultList;
    }
}
