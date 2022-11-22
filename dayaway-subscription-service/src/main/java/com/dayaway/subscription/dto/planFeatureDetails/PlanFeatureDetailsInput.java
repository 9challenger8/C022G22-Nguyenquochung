package com.dayaway.subscription.dto.planFeatureDetails;

import com.dayaway.subscription.core.common.Input;
import lombok.Data;

import java.util.UUID;

@Data
public class PlanFeatureDetailsInput extends Input {
    private UUID id;
    private UUID planId;
    private UUID planFeatureId;
    private String value;
}
