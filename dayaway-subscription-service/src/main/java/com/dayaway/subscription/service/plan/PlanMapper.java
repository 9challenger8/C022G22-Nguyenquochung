package com.dayaway.subscription.service.plan;


import com.dayaway.subscription.dto.plan.PlanDto;
import com.dayaway.subscription.dto.plan.PlanInput;
import com.dayaway.subscription.entity.plan.Plan;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlanMapper {

    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);

    @Mappings({

    })
    PlanDto entityToDto(Plan input);

    @Mappings({

    })
    List<PlanDto> entityToDto(List<Plan> input);


    //TODO FIX HERER
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", source = "input.status", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "type", source = "input.type", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "roleCode", source = "input.roleCode", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "monthsPerInterval", source = "input.monthsPerInterval", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "price", source = "input.price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "description", source = "input.description", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "name", source = "input.name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "code", source = "input.code", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            
    })
    Plan inputToEntity(PlanInput input);

    @Mappings({
//            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "status", source = "input.status", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "type", source = "input.type", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "roleCode", source = "input.roleCode", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "monthsPerInterval", source = "input.monthsPerInterval", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "price", source = "input.price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "description", source = "input.description", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "name", source = "input.name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "code", source = "input.code", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    Plan mergeInputAndEntity(@MappingTarget  Plan entity, PlanInput input);

}
