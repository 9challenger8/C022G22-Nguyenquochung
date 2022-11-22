package com.dayaway.subscription.dto.planFeature;

import com.dayaway.subscription.core.common.Input;
import lombok.Data;

import java.util.UUID;

@Data
public class PlanFeatureInput extends Input {
    private UUID id;
    private String name;
    private String code;
    private String typeValue;
    private PlanFeatureTypeEnum type;
}
