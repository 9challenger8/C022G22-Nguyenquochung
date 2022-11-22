package com.dayaway.subscription.entity.subscription;

import com.dayaway.subscription.core.common.AbstractAuditedEntity;
import com.dayaway.subscription.dto.subscription.SubscriptionRelatedTypeEnum;
import com.dayaway.subscription.dto.subscription.SubscriptionStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "subscription")
public class Subscription extends AbstractAuditedEntity {
    @Column(name = "plan_id", columnDefinition = "VARCHAR(40)")
    private UUID planId;
    @Column(name = "related_id", columnDefinition = "VARCHAR(40)")
    private UUID relatedId;
    @Column(name = "related_type")
    private SubscriptionRelatedTypeEnum relatedType;
    @Column(name = "status")
    private SubscriptionStatusEnum status;
    @Column(name = "start_date", columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name = "end_date", columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @Column(name = "auto_renew_enabled")
    private Boolean autoRenewEnabled;
}
