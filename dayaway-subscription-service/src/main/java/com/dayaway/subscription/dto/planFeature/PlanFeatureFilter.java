package com.dayaway.subscription.dto.planFeature;

import com.dayaway.subscription.core.common.Filter;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class PlanFeatureFilter extends Filter {
    private List<UUID> idList;
    private String name;
    private List<String> codeList;
    private List<String> typeValueList;
    private List<PlanFeatureTypeEnum> typeList;
}
