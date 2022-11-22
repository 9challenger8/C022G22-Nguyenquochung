package com.dayaway.subscription.dto.planFeatureDetails;

import com.dayaway.subscription.core.common.Filter;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class PlanFeatureDetailsFilter extends Filter {

    private List<UUID> idList;
    private List<UUID> planIdList;
    private List<UUID> planFeatureIdList;
    private String value;
}

