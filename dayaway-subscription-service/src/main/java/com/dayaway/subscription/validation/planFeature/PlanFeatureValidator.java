package com.dayaway.subscription.validation.planFeature;

import com.dayaway.subscription.core.validation.AValidator;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.IValidationField;
import com.dayaway.subscription.core.validation.ValidationNullObject;
import com.dayaway.subscription.dto.planFeature.PlanFeatureInput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanFeatureValidator extends AValidator<PlanFeatureInput> {
    @Override
    public List<IValidationField<?>> validationList(PlanFeatureInput input, ActionTypeEnum actionType) {
        List<IValidationField<?>> resultList = new ArrayList<>();
        resultList.add(new ValidationNullObject(input, PlanFeatureValidationMessage.NULL_INPUT));
        switch (actionType) {
            case CREATE:
                // resultList.add( new ValidationNullObject( input.getType() , PackageValidationMessage.NULL_TYPE));
                resultList.add(new ValidationNullObject(input.getCode(), PlanFeatureValidationMessage.REQUIRE_CODE));
                resultList.add(new ValidationNullObject(input.getName(), PlanFeatureValidationMessage.REQUIRE_NAME));
                resultList.add(new ValidationNullObject(input.getTypeValue(), PlanFeatureValidationMessage.REQUIRE_TYPE_VALUE));
                resultList.add(new ValidationNullObject(input.getType(), PlanFeatureValidationMessage.REQUIRE_TYPE));
                break;
            case UPDATE:
                resultList.add(new ValidationNullObject(input.getId(), PlanFeatureValidationMessage.REQUIRE_PLAN_FEATURE_ID));
                break;
            case DELETE:
                resultList.add(new ValidationNullObject(input.getId(), PlanFeatureValidationMessage.REQUIRE_PLAN_FEATURE_ID));
                break;
        }
        return resultList;
    }
}
