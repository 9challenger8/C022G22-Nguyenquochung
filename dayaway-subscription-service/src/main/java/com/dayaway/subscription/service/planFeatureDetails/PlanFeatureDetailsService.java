package com.dayaway.subscription.service.planFeatureDetails;

import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsDto;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsFilter;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsInput;

public interface PlanFeatureDetailsService {
    ResponseData<PlanFeatureDetailsDto> planFeatureDetailsList(PlanFeatureDetailsFilter filter);

    ResponseContent<PlanFeatureDetailsDto> updatePlanFeatureDetails(PlanFeatureDetailsInput input);

    ResponseContent<PlanFeatureDetailsDto> deletePlanFeatureDetails(PlanFeatureDetailsInput input);

    ResponseContent<PlanFeatureDetailsDto> createPlanFeatureDetails(PlanFeatureDetailsInput input);
}
