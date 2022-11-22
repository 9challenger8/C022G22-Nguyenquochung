package com.dayaway.subscription.dto.planFeatureDetails;

import com.dayaway.subscription.core.graphql.SchemaType;
import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import lombok.Data;

import java.util.UUID;


@Data
@SchemaType("PlanFeatureDetails")
public class PlanFeatureDetailsDto {
    private UUID id;
    private UUID planId;
    private UUID planFeatureId;
    private String value;
    private PlanFeatureDto planFeature;
}
