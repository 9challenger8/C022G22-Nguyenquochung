package com.dayaway.subscription.core.common;

import io.ebean.Model;
import io.ebean.annotation.*;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Data
public class AbstractAuditedEntity extends Model implements Serializable {
    private static final long serialVersionUID = 1634276783227812763L;
    @Id
//    @Column(columnDefinition = "VARCHAR(40)")
    public UUID id;

    @SoftDelete
    @Column(name = "soft_delete", columnDefinition = "BOOLEAN DEFAULT 0")
    private Boolean softDelete = false;

    @WhoCreated
    @Column(name = "created_by", nullable = false, length = 255)
    private String createdBy;

    @WhenCreated
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @WhoModified
    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @WhenModified
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    public AbstractAuditedEntity() {
        super();
    }

    public AbstractAuditedEntity(UUID id) {
        super();
        this.id = id;
    }
}