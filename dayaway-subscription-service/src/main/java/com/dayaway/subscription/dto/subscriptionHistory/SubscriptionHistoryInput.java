package com.dayaway.subscription.dto.subscriptionHistory;

import com.dayaway.subscription.core.common.Input;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class SubscriptionHistoryInput extends Input {
    private UUID id;
    private UUID subscriptionId;
    private BigDecimal paymentAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private SubscriptionHistoryPaymentStatusHistoryEnum paymentStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodStartDate;

}
