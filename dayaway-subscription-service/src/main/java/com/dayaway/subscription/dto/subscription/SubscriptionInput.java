package com.dayaway.subscription.dto.subscription;

import com.dayaway.subscription.core.common.Input;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class SubscriptionInput extends Input {
    private UUID id;
    private UUID planId;
    private UUID relatedId;
    private SubscriptionRelatedTypeEnum relatedType;
    private SubscriptionStatusEnum status;
    private Boolean autoRenewEnabled;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
