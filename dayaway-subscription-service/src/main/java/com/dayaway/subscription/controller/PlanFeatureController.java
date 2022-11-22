package com.dayaway.subscription.controller;

import com.dayaway.subscription.core.common.BaseController;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import com.dayaway.subscription.dto.planFeature.PlanFeatureFilter;
import com.dayaway.subscription.dto.planFeature.PlanFeatureInput;
import com.dayaway.subscription.service.planFeature.PlanFeatureService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class PlanFeatureController extends BaseController {

    @Autowired
    private PlanFeatureService service;

    @QueryMapping
    public ResponseData<PlanFeatureDto> planFeatureList(DataFetchingEnvironment env) {
        PlanFeatureFilter filter = mapEnv2Filter(env, PlanFeatureFilter.class);
        return service.planFeatureList(filter);
    }

    @MutationMapping
    public ResponseContent<PlanFeatureDto> updatePlanFeature(DataFetchingEnvironment env) {
        PlanFeatureInput input = mapEnv2Input(env, PlanFeatureInput.class);
        return service.updatePlanFeature(input);
    }

    @MutationMapping
    public ResponseContent<PlanFeatureDto> deletePlanFeature(DataFetchingEnvironment env) {
        PlanFeatureInput input = mapEnv2Input(env, PlanFeatureInput.class);
        return service.deletePlanFeature(input);
    }

    @MutationMapping
    public ResponseContent<PlanFeatureDto> createPlanFeature(DataFetchingEnvironment env) {
        PlanFeatureInput input = mapEnv2Input(env, PlanFeatureInput.class);
        return service.createPlanFeature(input);
    }

}