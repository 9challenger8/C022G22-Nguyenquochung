package com.dayaway.subscription.entity.planFeatureDetails;

import com.dayaway.subscription.core.common.AbstractAuditedEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name = "plan_feature_details")
public class PlanFeatureDetails extends AbstractAuditedEntity {
    @Column(name = "plan_id", columnDefinition = "VARCHAR(40)")
    private UUID planId;
    @Column(name = "plan_feature_id", columnDefinition = "VARCHAR(40)")
    private UUID planFeatureId;
    @Column(name = "value", columnDefinition = "VARCHAR(40)")
    private String value;

}
