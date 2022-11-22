package com.dayaway.subscription.service.subscriptionHistory;

import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryDto;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryInput;
import com.dayaway.subscription.entity.subscriptionHistory.SubscriptionHistory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SubscriptionHistoryMapper {

    SubscriptionHistoryMapper INSTANCE = Mappers.getMapper(SubscriptionHistoryMapper.class);

    @Mappings({

    })
    SubscriptionHistoryDto entityToDto(SubscriptionHistory input);

    @Mappings({

    })
    List<SubscriptionHistoryDto> entityToDto(List<SubscriptionHistory> input);


    //TODO FIX HERER
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "subscriptionId", source = "input.subscriptionId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "paymentAmount", source = "input.paymentAmount", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "paymentDate", source = "input.paymentDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "paymentStatus", source = "input.paymentStatus", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "periodStartDate", source = "input.periodStartDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    SubscriptionHistory inputToEntity(SubscriptionHistoryInput input);

    @Mappings({
//            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "subscriptionId", source = "input.subscriptionId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "paymentAmount", source = "input.paymentAmount", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "paymentDate", source = "input.paymentDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "paymentStatus", source = "input.paymentStatus", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
            @Mapping(target = "periodStartDate", source = "input.periodStartDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE),
    })
    SubscriptionHistory mergeInputAndEntity(@MappingTarget SubscriptionHistory entity, SubscriptionHistoryInput input);

}
