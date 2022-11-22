package com.dayaway.subscription.service.plan;

import com.dayaway.subscription.core.common.Filter;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseContentStatusEnum;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.core.utils.EbeanUtils;
import com.dayaway.subscription.core.utils.collectionUtils.HcgCollectionUtils;
import com.dayaway.subscription.core.utils.collectionUtils.MappingField;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.ValidationMessage;
import com.dayaway.subscription.dto.plan.PlanDto;
import com.dayaway.subscription.dto.plan.PlanExpandEnum;
import com.dayaway.subscription.dto.plan.PlanFilter;
import com.dayaway.subscription.dto.plan.PlanInput;
import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import com.dayaway.subscription.dto.planFeature.PlanFeatureFilter;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsDto;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsFilter;
import com.dayaway.subscription.entity.plan.Plan;
import com.dayaway.subscription.entity.plan.query.QPlan;
import com.dayaway.subscription.entity.planFeatureDetails.query.QPlanFeatureDetails;
import com.dayaway.subscription.service.planFeature.PlanFeatureMapper;
import com.dayaway.subscription.service.planFeature.PlanFeatureService;
import com.dayaway.subscription.service.planFeatureDetails.PlanFeatureDetailsMapper;
import com.dayaway.subscription.service.planFeatureDetails.PlanFeatureDetailsService;
import com.dayaway.subscription.validation.plan.PlanValidationMessage;
import com.dayaway.subscription.validation.plan.PlanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanValidator validator;

    @Autowired
    private PlanFeatureDetailsMapper planFeatureDetailsMapper;

    @Autowired
    private PlanFeatureMapper planFeatureMapper;

    @Autowired
    private PlanFeatureDetailsService planFeatureDetailsService;

    @Autowired
    private PlanFeatureService planFeatureService;

    @Autowired
    private HcgCollectionUtils hcgCollectionUtils;

    @Override
    public ResponseData<PlanDto> planList(PlanFilter filter) {
        filter = Filter.setDefaultValue(filter, PlanFilter.class);
        QPlan query = new QPlan().where();


        //Filter query
        EbeanUtils.setEqualOrInQuery(query.id, filter.getIdList());
        EbeanUtils.setEqualOrInQuery(query.status, filter.getStatusList());
        EbeanUtils.setEqualOrInQuery(query.type, filter.getTypeList());
        EbeanUtils.setEqualOrInQuery(query.code, filter.getCodeList());
        EbeanUtils.setLikeQuery(query.name, filter.getName(), true);
        EbeanUtils.setEqualOrInQuery(query.description, filter.getDescriptionList());
        EbeanUtils.setEqualOrInQuery(query.roleCode, filter.getRoleCodeList());
        EbeanUtils.setEqualOrInQuery(query.monthsPerInterval, filter.getMonthsPerIntervalList());
        EbeanUtils.setEqualOrInQuery(query.price, filter.getPriceList());


        //Filter query - End

        //Find result
        ResponseData<Plan> entityList = EbeanUtils.queryEntity(query, filter);
        ResponseData<PlanDto> responseData = new ResponseData(entityList, PlanMapper.INSTANCE.entityToDto(entityList.getData()));

        try {
            this.expandData(responseData.getData(), filter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return responseData;
    }

    private void expandData(List<PlanDto> resultList, PlanFilter filter) throws IOException {
        if (resultList.size() == 0) {
            return;
        }
        if (filter.getExpand() != null && filter.getExpand().size() > 0) {
            List<UUID> listIdPlanFeatureDetails = resultList
                    .stream()
                    .map(PlanDto::getId)
                    .filter(Objects::nonNull)
                    .toList();
            QPlanFeatureDetails planFeatureDetailsQuery = new QPlanFeatureDetails().where();
            planFeatureDetailsQuery.planId.in(listIdPlanFeatureDetails);
            List<PlanFeatureDetailsDto> planFeatureDetailsDtoList = new ArrayList<>();
            if (filter.getExpand().contains(PlanExpandEnum.planFeatureDetails.name())) {
                PlanFeatureDetailsFilter planFeatureDetailsFilter = PlanFeatureDetailsFilter.builder().planIdList(listIdPlanFeatureDetails).build();
                ResponseData<PlanFeatureDetailsDto> planFeatureDetailsResponse = planFeatureDetailsService.planFeatureDetailsList(planFeatureDetailsFilter);
                planFeatureDetailsDtoList = planFeatureDetailsResponse.getData();
            }


            List<UUID> listIdPlanFeature = planFeatureDetailsDtoList
                    .stream()
                    .map(PlanFeatureDetailsDto::getPlanFeatureId)
                    .collect(Collectors.toList());
//            QPlanFeature planFeatureQuery = new QPlanFeature().where();
//            planFeatureQuery.id.in(listIdPlanFeature);
            List<PlanFeatureDto> planFeatureDtoList = new ArrayList<>();
            if (filter.getExpand().contains(PlanExpandEnum.planFeature.name())) {
                PlanFeatureFilter planFeatureFilter = PlanFeatureFilter.builder().idList(listIdPlanFeature).build();
                ResponseData<PlanFeatureDto> planFeatureResponse = planFeatureService.planFeatureList(planFeatureFilter);
                planFeatureDtoList = planFeatureResponse.getData();
            }



            MappingField planFeatureMapping = new MappingField(planFeatureDtoList, (Function<PlanFeatureDetailsDto, UUID>) PlanFeatureDetailsDto::getPlanFeatureId,
                    (Function<PlanFeatureDto, UUID>) PlanFeatureDto::getId, (BiConsumer<PlanFeatureDetailsDto, PlanFeatureDto>) PlanFeatureDetailsDto::setPlanFeature,
                    UUID.class, MappingField.FieldTypeEnum.SINGLE_FIELD);

            List<MappingField> mappingFieldList = new ArrayList<>();
            mappingFieldList.add(planFeatureMapping);

            //Merge collection
            hcgCollectionUtils.mergeCollection(planFeatureDetailsDtoList, mappingFieldList);

            MappingField planFeatureDetailsMapping = new MappingField(planFeatureDetailsDtoList, (Function<PlanDto, UUID>) PlanDto::getId,
                    (Function<PlanFeatureDetailsDto, UUID>) PlanFeatureDetailsDto::getPlanId,
                    (BiConsumer<PlanDto, List<PlanFeatureDetailsDto>>) PlanDto::setPlanFeatureDetailsList,
                    UUID.class, MappingField.FieldTypeEnum.COLLECTION_FIELD);

            List<MappingField> mappingFieldList2 = new ArrayList<>();
            mappingFieldList2.add(planFeatureDetailsMapping);
            hcgCollectionUtils.mergeCollection(resultList, mappingFieldList2);
        }

    }

    @Override
    public ResponseContent<PlanDto> updatePlan(PlanInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.UPDATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }

        Plan qentity = new QPlan().where().id.equalTo(input.getId()).findOne();

        if (qentity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(PlanValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }

        Plan Plan = PlanMapper.INSTANCE.mergeInputAndEntity(qentity, input);

        //Flush to database
        Plan.update();

        //Set response
        result = PlanMapper.INSTANCE.entityToDto(Plan);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanValidationMessage.UPDATE_SUCCESS);

        ResponseContent<PlanDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<PlanDto> deletePlan(PlanInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.DELETE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        Plan queryEntity = new QPlan().where().id.equalTo(input.getId()).findOne();

        if (queryEntity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(PlanValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }

        Plan Plan = PlanMapper.INSTANCE.mergeInputAndEntity(queryEntity, input);
        Plan.setSoftDelete(true);

        //Flush to database
        Plan.update();

        //Set response
        result = PlanMapper.INSTANCE.entityToDto(Plan);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanValidationMessage.DELETE_SUCCESS);

        ResponseContent<PlanDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<PlanDto> createPlan(PlanInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.CREATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }
        Plan Plan = PlanMapper.INSTANCE.inputToEntity(input);


        //Flush to database
        Plan.save();

        //Set response
        result = PlanMapper.INSTANCE.entityToDto(Plan);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanValidationMessage.CREATE_SUCCESS);

        ResponseContent<PlanDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }
}
