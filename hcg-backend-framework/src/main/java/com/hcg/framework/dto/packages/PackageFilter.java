package com.hcg.framework.dto.packages;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hcg.framework.core.common.Filter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageFilter extends Filter {
    private static final long serialVersionUID = 7354220905908208167L;

    private UUID hotelId;

    private Boolean isPromoted;

    private Boolean isFeatured;

    private String categoryTag;

    private String seoString;

}
