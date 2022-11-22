package com.dayaway.subscription.dto.subscription;

import com.dayaway.subscription.core.common.Filter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class SubscriptionFilter extends Filter {
    private List<UUID> idList;
    private List<UUID> planIdList;
    private List<UUID> relatedIdList;
    private List<SubscriptionRelatedTypeEnum> relatedTypeList;
    private List<SubscriptionStatusEnum> statusList;
    private List<Boolean> autoRenewEnabledList;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
