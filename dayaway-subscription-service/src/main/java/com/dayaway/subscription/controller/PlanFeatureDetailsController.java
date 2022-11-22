package com.dayaway.subscription.controller;

import com.dayaway.subscription.core.common.BaseController;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsDto;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsFilter;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsInput;
import com.dayaway.subscription.service.planFeatureDetails.PlanFeatureDetailsService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class PlanFeatureDetailsController extends BaseController {

    @Autowired
    private PlanFeatureDetailsService service;

    @QueryMapping
    public ResponseData<PlanFeatureDetailsDto> planFeatureDetailsList(DataFetchingEnvironment env) {
        PlanFeatureDetailsFilter filter = mapEnv2Filter(env, PlanFeatureDetailsFilter.class);
        return service.planFeatureDetailsList(filter);
    }

    @MutationMapping
    public ResponseContent<PlanFeatureDetailsDto> updatePlanFeatureDetails(DataFetchingEnvironment env) {
        PlanFeatureDetailsInput input = mapEnv2Input(env, PlanFeatureDetailsInput.class);
        return service.updatePlanFeatureDetails(input);
    }

    @MutationMapping
    public ResponseContent<PlanFeatureDetailsDto> deletePlanFeatureDetails(DataFetchingEnvironment env) {
        PlanFeatureDetailsInput input = mapEnv2Input(env, PlanFeatureDetailsInput.class);
        return service.deletePlanFeatureDetails(input);
    }

    @MutationMapping
    public ResponseContent<PlanFeatureDetailsDto> createPlanFeatureDetails(DataFetchingEnvironment env) {
        PlanFeatureDetailsInput input = mapEnv2Input(env, PlanFeatureDetailsInput.class);
        return service.createPlanFeatureDetails(input);
    }

}