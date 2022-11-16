package com.hcg.framework.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hcg.framework.core.common.Input;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostInput extends Input
{
    private static final long serialVersionUID = -4819558256270014965L;

    private String id;
    private String title;
    private String category;
    private LocalDate date ;

}
