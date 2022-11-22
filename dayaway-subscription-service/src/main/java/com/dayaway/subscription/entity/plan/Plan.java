package com.dayaway.subscription.entity.plan;

import com.dayaway.subscription.core.common.AbstractAuditedEntity;
import com.dayaway.subscription.dto.plan.PlanStatusEnum;
import com.dayaway.subscription.dto.plan.PlanTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "plan")
public class Plan extends AbstractAuditedEntity {
    @Column(name = "code", columnDefinition = "VARCHAR(40)")
    private String code;
    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;
    @Column(name = "description", columnDefinition = "VARCHAR(40)")
    private String description;
    @Column(name = "price", columnDefinition = "DECIMAL(19,4)")
    private BigDecimal price;
    ;
    @Column(name = "months_per_interval", columnDefinition = "VARCHAR(40)")
    private String monthsPerInterval;
    @Column(name = "type", columnDefinition = "VARCHAR(40)")
    private PlanTypeEnum type;
    @Column(name = "status", columnDefinition = "VARCHAR(40)")
    private PlanStatusEnum status;
    @Column(name = "role_code", columnDefinition = "VARCHAR(40)")
    private String roleCode;

}
