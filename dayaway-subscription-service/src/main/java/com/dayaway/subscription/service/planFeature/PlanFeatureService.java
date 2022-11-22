package com.dayaway.subscription.service.planFeature;

import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import com.dayaway.subscription.dto.planFeature.PlanFeatureFilter;
import com.dayaway.subscription.dto.planFeature.PlanFeatureInput;

public interface PlanFeatureService {
    ResponseData<PlanFeatureDto> planFeatureList(PlanFeatureFilter filter);

    ResponseContent<PlanFeatureDto> updatePlanFeature(PlanFeatureInput input);

    ResponseContent<PlanFeatureDto> deletePlanFeature(PlanFeatureInput input);

    ResponseContent<PlanFeatureDto> createPlanFeature(PlanFeatureInput input);
}
