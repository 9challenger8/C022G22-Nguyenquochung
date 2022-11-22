package com.dayaway.subscription.service.planFeatureDetails;

import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsDto;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsInput;
import com.dayaway.subscription.entity.planFeatureDetails.PlanFeatureDetails;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlanFeatureDetailsMapper {

    PlanFeatureDetailsMapper INSTANCE = Mappers.getMapper(PlanFeatureDetailsMapper.class);

    @Mappings({

    })
    PlanFeatureDetailsDto entityToDto(PlanFeatureDetails input);

    @Mappings({

    })
    List<PlanFeatureDetailsDto> entityToDto(List<PlanFeatureDetails> input);


    //TODO FIX HERER
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "planId", source = "input.planId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "planFeatureId", source = "input.planFeatureId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "value", source = "input.value", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),

    })
    PlanFeatureDetails inputToEntity(PlanFeatureDetailsInput input);

    @Mappings({
//            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "planId", source = "input.planId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "planFeatureId", source = "input.planFeatureId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "value", source = "input.value", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    PlanFeatureDetails mergeInputAndEntity(@MappingTarget PlanFeatureDetails entity, PlanFeatureDetailsInput input);

}
