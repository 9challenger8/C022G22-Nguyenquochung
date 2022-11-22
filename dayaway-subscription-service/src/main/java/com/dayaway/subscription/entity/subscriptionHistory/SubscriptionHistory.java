package com.dayaway.subscription.entity.subscriptionHistory;

import com.dayaway.subscription.core.common.AbstractAuditedEntity;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryPaymentStatusHistoryEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "subscription_history")
public class SubscriptionHistory extends AbstractAuditedEntity {
    @Column(name = "subscription_id", columnDefinition = "VARCHAR(40)")
    private UUID subscriptionId;
    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;
    @Column(name = "payment_date", columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    @Column(name = "payment_status")
    private SubscriptionHistoryPaymentStatusHistoryEnum paymentStatus;
    @Column(name = "period_start_date", columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodStartDate;

}
