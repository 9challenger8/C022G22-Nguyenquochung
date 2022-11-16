package com.hcg.framework.dto.packages;

import com.hcg.framework.core.common.Input;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class PackageInput extends Input {
    private static final long serialVersionUID = -4819558256270014965L;

    private UUID id;

    private String code;

    private String name;

    private List<String> emailAddressList;

    private UUID imgId;

    private String packageDetails;

    private UUID hotelId;

    private String status;


    private Integer sequence;

    private BigDecimal basePrice;

    private Boolean isPromoted;

    private Boolean isFeatured;

    private String categoryTag;

    private String hotelCxlPolicyCode;

    private Integer cancellationPriorHour;

    private Boolean isRefundable;

}
