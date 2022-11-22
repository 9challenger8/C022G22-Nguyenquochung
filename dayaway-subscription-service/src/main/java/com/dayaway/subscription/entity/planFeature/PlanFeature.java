package com.dayaway.subscription.entity.planFeature;

import com.dayaway.subscription.core.common.AbstractAuditedEntity;
import com.dayaway.subscription.dto.planFeature.PlanFeatureTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "plan_feature")
public class PlanFeature extends AbstractAuditedEntity {
    @Column(name = "name", columnDefinition = "VARCHAR(60)")
    private String name;
    @Column(name = "code", columnDefinition = "VARCHAR(40)")
    private String code;
    @Column(name = "type_value", columnDefinition = "VARCHAR(40)")
    private String typeValue;
    @Column(name = "type", columnDefinition = "VARCHAR(40)")
    private PlanFeatureTypeEnum type;

}

