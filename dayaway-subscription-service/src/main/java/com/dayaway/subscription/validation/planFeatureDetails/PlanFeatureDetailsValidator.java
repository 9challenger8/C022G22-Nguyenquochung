package com.dayaway.subscription.validation.planFeatureDetails;

import com.dayaway.subscription.core.validation.AValidator;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.IValidationField;
import com.dayaway.subscription.core.validation.ValidationNullObject;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsInput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanFeatureDetailsValidator extends AValidator<PlanFeatureDetailsInput> {
    @Override
    public List<IValidationField<?>> validationList(PlanFeatureDetailsInput input, ActionTypeEnum actionType) {
        List<IValidationField<?>> resultList = new ArrayList<>();
        resultList.add(new ValidationNullObject(input, PlanFeatureDetailsValidationMessage.NULL_INPUT));
        switch (actionType) {
            case CREATE:
                // resultList.add( new ValidationNullObject( input.getType() , PackageValidationMessage.NULL_TYPE));
                resultList.add(new ValidationNullObject(input.getPlanFeatureId(), PlanFeatureDetailsValidationMessage.REQUIRE_PLAN_FEATURE_ID));
                resultList.add(new ValidationNullObject(input.getPlanId(), PlanFeatureDetailsValidationMessage.REQUIRE_PLAN_ID));
                resultList.add(new ValidationNullObject(input.getValue(), PlanFeatureDetailsValidationMessage.REQUIRE_VALUE));

                break;
            case UPDATE:
                resultList.add(new ValidationNullObject(input.getId(), PlanFeatureDetailsValidationMessage.REQUIRE_PLAN_FEATURE_DETAILS_HISTORY_ID));
                break;
            case DELETE:
                resultList.add(new ValidationNullObject(input.getId(), PlanFeatureDetailsValidationMessage.REQUIRE_PLAN_FEATURE_DETAILS_HISTORY_ID));
                break;
        }
        return resultList;
    }
}
