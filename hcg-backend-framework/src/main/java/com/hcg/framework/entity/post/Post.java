package com.hcg.framework.entity.post;

import com.hcg.framework.core.common.AbstractAuditedEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "post")
public class Post extends AbstractAuditedEntity {
    private static final long serialVersionUID = -6950597450649041254L;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private LocalDate date;

    public Post()
    {
        super();
    }

    public Post(UUID id)
    {
        super();
    }
}
