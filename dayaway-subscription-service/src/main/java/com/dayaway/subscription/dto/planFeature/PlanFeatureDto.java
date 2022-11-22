package com.dayaway.subscription.dto.planFeature;

import com.dayaway.subscription.core.graphql.SchemaType;
import lombok.Data;

import java.util.UUID;

@SchemaType("PlanFeature")
@Data
public class PlanFeatureDto {
    private UUID id;
    private String name;
    private String code;
    private String typeValue;
    private PlanFeatureTypeEnum type;
}
