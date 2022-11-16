package com.hcg.framework.dto.post;

import com.hcg.framework.core.common.AbstractAuditedDto;
import com.hcg.framework.core.graphql.SchemaType;
import com.hcg.framework.dto.packages.PackageDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@SchemaType("Post")
public class PostDto extends AbstractAuditedDto {
    private UUID id;
    private String title;
    private String category;
    private LocalDate date ;

    private List<PackageDto> packages;


}
