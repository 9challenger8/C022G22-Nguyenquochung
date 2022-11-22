package com.dayaway.subscription.dto.plan;

import com.dayaway.subscription.core.common.Filter;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data

public class PlanFilter extends Filter {
    private List<UUID> idList;
    private List<String> codeList;
    private String name;
    private List<String> descriptionList;
    private List<BigDecimal> priceList;
    private List<String> monthsPerIntervalList;
    private List<PlanTypeEnum> typeList;
    private List<PlanStatusEnum> statusList;
    private List<String> roleCodeList;

}
