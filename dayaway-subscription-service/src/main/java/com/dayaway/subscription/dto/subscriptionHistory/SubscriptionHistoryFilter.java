package com.dayaway.subscription.dto.subscriptionHistory;

import com.dayaway.subscription.core.common.Filter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class SubscriptionHistoryFilter extends Filter {
    private List<UUID> idList;
    private List<UUID> subscriptionIdList;
    private List<BigDecimal> paymentAmountList;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private List<SubscriptionHistoryPaymentStatusHistoryEnum> paymentStatusList;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodStartDate;
}
