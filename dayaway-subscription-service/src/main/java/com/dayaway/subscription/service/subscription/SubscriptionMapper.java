package com.dayaway.subscription.service.subscription;

import com.dayaway.subscription.dto.subscription.SubscriptionDto;
import com.dayaway.subscription.dto.subscription.SubscriptionInput;
import com.dayaway.subscription.entity.subscription.Subscription;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    @Mappings({

    })
    SubscriptionDto entityToDto(Subscription input);

    @Mappings({

    })
    List<SubscriptionDto> entityToDto(List<Subscription> input);


    //TODO FIX HERER
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", source = "input.status", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "autoRenewEnabled", source = "input.autoRenewEnabled", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "startDate", source = "input.startDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "endDate", source = "input.endDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "planId", source = "input.planId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "relatedId", source = "input.relatedId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "relatedType", source = "input.relatedType", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),

    })
    Subscription inputToEntity(SubscriptionInput input);

    @Mappings({
//            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "status", source = "input.status", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "autoRenewEnabled", source = "input.autoRenewEnabled", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "startDate", source = "input.startDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "endDate", source = "input.endDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "planId", source = "input.planId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "relatedId", source = "input.relatedId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "relatedType", source = "input.relatedType", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    Subscription mergeInputAndEntity(@MappingTarget Subscription entity, SubscriptionInput input);

}
