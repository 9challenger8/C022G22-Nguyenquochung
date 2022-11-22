package com.dayaway.subscription.dto.plan;

import com.dayaway.subscription.core.common.Input;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class PlanInput extends Input {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private String monthsPerInterval;
    private PlanTypeEnum type;
    private PlanStatusEnum status;
    private String roleCode;

}
