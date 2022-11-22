package com.dayaway.subscription.dto.plan;

import com.dayaway.subscription.core.graphql.SchemaType;
import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsDto;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@SchemaType("Plan")
@Data
public class PlanDto {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private String monthsPerInterval;
    private PlanTypeEnum type;
    private PlanStatusEnum status;
    private String roleCode;
    private List<PlanFeatureDetailsDto> planFeatureDetailsList;
    private List<PlanFeatureDto> planFeatureList;

    public List<PlanFeatureDto> getPlanFeatureList() {
        if (!CollectionUtils.isEmpty(planFeatureDetailsList)) {
            return planFeatureDetailsList.stream()
                    .map(PlanFeatureDetailsDto::getPlanFeature)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
