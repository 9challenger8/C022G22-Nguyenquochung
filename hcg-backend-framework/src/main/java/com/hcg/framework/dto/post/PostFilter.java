package com.hcg.framework.dto.post;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hcg.framework.core.common.Filter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostFilter extends Filter
{
    private static final long serialVersionUID = 7354220905908208167L;

    private int count;

    private int offset;
}