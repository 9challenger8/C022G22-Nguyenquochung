package com.dayaway.subscription.service.plan;

import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.plan.PlanDto;
import com.dayaway.subscription.dto.plan.PlanFilter;
import com.dayaway.subscription.dto.plan.PlanInput;

public interface PlanService {
    ResponseData<PlanDto> planList(PlanFilter filter);

    ResponseContent<PlanDto> updatePlan(PlanInput input);

    ResponseContent<PlanDto> deletePlan(PlanInput input);

    ResponseContent<PlanDto> createPlan(PlanInput input);
}
