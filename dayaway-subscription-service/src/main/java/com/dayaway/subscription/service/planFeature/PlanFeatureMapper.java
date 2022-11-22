package com.dayaway.subscription.service.planFeature;

import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import com.dayaway.subscription.dto.planFeature.PlanFeatureInput;
import com.dayaway.subscription.entity.planFeature.PlanFeature;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlanFeatureMapper {

    PlanFeatureMapper INSTANCE = Mappers.getMapper(PlanFeatureMapper.class);

    @Mappings({

    })
    PlanFeatureDto entityToDto(PlanFeature input);

    @Mappings({

    })
    List<PlanFeatureDto> entityToDto(List<PlanFeature> input);


    //TODO FIX HERER
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "typeValue", source = "input.typeValue", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "type", source = "input.type", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "code", source = "input.code", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "name", source = "input.name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),

    })
    PlanFeature inputToEntity(PlanFeatureInput input);

    @Mappings({
//            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "typeValue", source = "input.typeValue", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "type", source = "input.type", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "code", source = "input.code", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "name", source = "input.name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    PlanFeature mergeInputAndEntity(@MappingTarget PlanFeature entity, PlanFeatureInput input);

}
