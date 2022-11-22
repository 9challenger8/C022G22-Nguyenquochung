package com.dayaway.subscription.validation.plan;

import com.dayaway.subscription.core.validation.AValidator;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.IValidationField;
import com.dayaway.subscription.core.validation.ValidationNullObject;
import com.dayaway.subscription.dto.plan.PlanInput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanValidator extends AValidator<PlanInput> {
    @Override
    public List<IValidationField<?>> validationList(PlanInput input, ActionTypeEnum actionType) {
        List<IValidationField<?>> resultList = new ArrayList<>();
        resultList.add(new ValidationNullObject(input, PlanValidationMessage.NULL_INPUT));
        switch (actionType) {
            case CREATE:
                // resultList.add( new ValidationNullObject( input.getType() , PackageValidationMessage.NULL_TYPE));
                resultList.add(new ValidationNullObject(input.getName(), PlanValidationMessage.REQUIRE_NAME));
                resultList.add(new ValidationNullObject(input.getCode(), PlanValidationMessage.REQUIRE_CODE));
                break;
            case UPDATE:
                resultList.add(new ValidationNullObject(input.getId(), PlanValidationMessage.REQUIRE_PLAN_ID));
                break;
            case DELETE:
                resultList.add(new ValidationNullObject(input.getId(), PlanValidationMessage.REQUIRE_PLAN_ID));
                break;
        }
        return resultList;
    }
}
