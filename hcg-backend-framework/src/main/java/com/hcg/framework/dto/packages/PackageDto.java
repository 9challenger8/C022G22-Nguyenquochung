package com.hcg.framework.dto.packages;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class PackageDto
{
    private static final long serialVersionUID = 3817882574989957263L;

    private UUID id;

    private String code;

    private String name;

    private List<String> emailAddressList;

    private String corporateCode;

    private UUID imgId;

    private String packageDetails;

    private String termAndCondition;

    private UUID hotelId;

    private String status;


    private UUID roomTypeId;

    private Integer maxAdults;

    private Integer maxChild;

    private Integer sequence;

    private BigDecimal basePrice;

    private Boolean isPromoted;

    private Boolean isFeatured;

    private String categoryTag;

    private String[] categoryList;

    private String hotelCxlPolicyCode;

    private BigDecimal taxRate;

    private BigDecimal serviceFee;

    private Boolean isTaxRateApplicable;

    private Boolean isServiceFeeApplicable;

    private BigDecimal depositValue;

    private Boolean isOverrideHotelFee;

    private Integer minAdvanceBooking;

    private Boolean isMinAdvanceBookingValid;

    private Boolean isOverrideHotelCxlPolicy;


    private Integer cancellationPriorHour;

    private Boolean isRefundable;

    private String summary;

    private String availability;

    private String checkinDetail;

    private String seoString;

    private String keywords;


}
