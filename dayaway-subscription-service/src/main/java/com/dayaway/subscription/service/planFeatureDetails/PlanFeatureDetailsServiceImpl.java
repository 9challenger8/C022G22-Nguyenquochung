package com.dayaway.subscription.service.planFeatureDetails;

import com.dayaway.subscription.core.common.Filter;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseContentStatusEnum;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.core.utils.EbeanUtils;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.ValidationMessage;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsDto;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsFilter;
import com.dayaway.subscription.dto.planFeatureDetails.PlanFeatureDetailsInput;
import com.dayaway.subscription.entity.planFeatureDetails.PlanFeatureDetails;
import com.dayaway.subscription.entity.planFeatureDetails.query.QPlanFeatureDetails;
import com.dayaway.subscription.validation.planFeatureDetails.PlanFeatureDetailsValidationMessage;
import com.dayaway.subscription.validation.planFeatureDetails.PlanFeatureDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanFeatureDetailsServiceImpl implements PlanFeatureDetailsService {

    @Autowired
    private PlanFeatureDetailsValidator validator;

    @Override
    public ResponseData<PlanFeatureDetailsDto> planFeatureDetailsList(PlanFeatureDetailsFilter filter) {
        filter = Filter.setDefaultValue(filter, PlanFeatureDetailsFilter.class);
        QPlanFeatureDetails query = new QPlanFeatureDetails().where();


        //Filter query
        EbeanUtils.setEqualOrInQuery(query.id, filter.getIdList());
        EbeanUtils.setEqualOrInQuery(query.planFeatureId, filter.getPlanFeatureIdList());
        EbeanUtils.setEqualOrInQuery(query.planId, filter.getPlanIdList());
        EbeanUtils.setLikeQuery(query.value, filter.getValue(), true);

        //Filter query - End

        //Find result
        ResponseData<PlanFeatureDetails> entityList = EbeanUtils.queryEntity(query, filter);
        ResponseData<PlanFeatureDetailsDto> responseData = new ResponseData(entityList, PlanFeatureDetailsMapper.INSTANCE.entityToDto(entityList.getData()));
        return responseData;
    }

    @Override
    public ResponseContent<PlanFeatureDetailsDto> updatePlanFeatureDetails(PlanFeatureDetailsInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanFeatureDetailsDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.UPDATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        PlanFeatureDetails qentity = new QPlanFeatureDetails().where().id.equalTo(input.getId()).findOne();

        if (qentity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(PlanFeatureDetailsValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }


        PlanFeatureDetails PlanFeatureDetails = PlanFeatureDetailsMapper.INSTANCE.mergeInputAndEntity(qentity, input);

        //Flush to database
        PlanFeatureDetails.update();

        //Set response
        result = PlanFeatureDetailsMapper.INSTANCE.entityToDto(PlanFeatureDetails);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanFeatureDetailsValidationMessage.UPDATE_SUCCESS);

        ResponseContent<PlanFeatureDetailsDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<PlanFeatureDetailsDto> deletePlanFeatureDetails(PlanFeatureDetailsInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanFeatureDetailsDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.DELETE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        PlanFeatureDetails queryEntity = new QPlanFeatureDetails().where().id.equalTo(input.getId()).findOne();

        if (queryEntity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(PlanFeatureDetailsValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }

        PlanFeatureDetails PlanFeatureDetails = PlanFeatureDetailsMapper.INSTANCE.mergeInputAndEntity(queryEntity, input);
        PlanFeatureDetails.setSoftDelete(true);

        //Flush to database
        PlanFeatureDetails.update();

        //Set response
        result = PlanFeatureDetailsMapper.INSTANCE.entityToDto(PlanFeatureDetails);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanFeatureDetailsValidationMessage.DELETE_SUCCESS);

        ResponseContent<PlanFeatureDetailsDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<PlanFeatureDetailsDto> createPlanFeatureDetails(PlanFeatureDetailsInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanFeatureDetailsDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.CREATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }
        PlanFeatureDetails PlanFeatureDetails = PlanFeatureDetailsMapper.INSTANCE.inputToEntity(input);


        //Flush to database
        PlanFeatureDetails.save();

        //Set response
        result = PlanFeatureDetailsMapper.INSTANCE.entityToDto(PlanFeatureDetails);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanFeatureDetailsValidationMessage.CREATE_SUCCESS);

        ResponseContent<PlanFeatureDetailsDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }
}
