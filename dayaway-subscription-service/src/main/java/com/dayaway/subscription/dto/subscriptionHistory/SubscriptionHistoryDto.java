package com.dayaway.subscription.dto.subscriptionHistory;

import com.dayaway.subscription.core.graphql.SchemaType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@SchemaType("SubscriptionHistory")
public class SubscriptionHistoryDto {
    private UUID id;
    private UUID subscriptionId;
    private BigDecimal paymentAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private SubscriptionHistoryPaymentStatusHistoryEnum paymentStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodStartDate;
}
