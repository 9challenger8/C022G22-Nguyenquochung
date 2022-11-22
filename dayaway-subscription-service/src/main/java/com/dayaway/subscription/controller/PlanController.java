package com.dayaway.subscription.controller;

import com.dayaway.subscription.core.common.BaseController;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.dto.plan.PlanDto;
import com.dayaway.subscription.dto.plan.PlanFilter;
import com.dayaway.subscription.dto.plan.PlanInput;
import com.dayaway.subscription.service.plan.PlanService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class PlanController extends BaseController {

    @Autowired
    private PlanService service;

    @QueryMapping
    public ResponseData<PlanDto> planList(DataFetchingEnvironment env) {
        PlanFilter filter = mapEnv2Filter(env, PlanFilter.class);
        return service.planList(filter);
    }

    @MutationMapping
    public ResponseContent<PlanDto> updatePlan(DataFetchingEnvironment env) {
        PlanInput input = mapEnv2Input(env, PlanInput.class);
        return service.updatePlan(input);
    }

    @MutationMapping
    public ResponseContent<PlanDto> deletePlan(DataFetchingEnvironment env) {
        PlanInput input = mapEnv2Input(env, PlanInput.class);
        return service.deletePlan(input);
    }

    @MutationMapping
    public ResponseContent<PlanDto> createPlan(DataFetchingEnvironment env) {
        PlanInput input = mapEnv2Input(env, PlanInput.class);
        return service.createPlan(input);
    }

}