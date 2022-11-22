package com.dayaway.subscription.service.planFeature;

import com.dayaway.subscription.core.common.Filter;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseContentStatusEnum;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.core.utils.EbeanUtils;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.ValidationMessage;
import com.dayaway.subscription.dto.planFeature.PlanFeatureDto;
import com.dayaway.subscription.dto.planFeature.PlanFeatureFilter;
import com.dayaway.subscription.dto.planFeature.PlanFeatureInput;
import com.dayaway.subscription.entity.planFeature.PlanFeature;
import com.dayaway.subscription.entity.planFeature.query.QPlanFeature;
import com.dayaway.subscription.validation.planFeature.PlanFeatureValidationMessage;
import com.dayaway.subscription.validation.planFeature.PlanFeatureValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanFeatureServiceImpl implements PlanFeatureService {

    @Autowired
    private PlanFeatureValidator validator;

    @Override
    public ResponseData<PlanFeatureDto> planFeatureList(PlanFeatureFilter filter) {
        filter = Filter.setDefaultValue(filter, PlanFeatureFilter.class);
        QPlanFeature query = new QPlanFeature().where();


        //Filter query
        EbeanUtils.setEqualOrInQuery(query.id, filter.getIdList());
        EbeanUtils.setEqualOrInQuery(query.code, filter.getCodeList());
        EbeanUtils.setLikeQuery(query.name, filter.getName(), true);
        EbeanUtils.setEqualOrInQuery(query.type, filter.getTypeList());
        EbeanUtils.setEqualOrInQuery(query.typeValue, filter.getTypeValueList());

        //Filter query - End

        //Find result
        ResponseData<PlanFeature> entityList = EbeanUtils.queryEntity(query, filter);
        ResponseData<PlanFeatureDto> responseData = new ResponseData(entityList, PlanFeatureMapper.INSTANCE.entityToDto(entityList.getData()));
        return responseData;
    }

    @Override
    public ResponseContent<PlanFeatureDto> updatePlanFeature(PlanFeatureInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanFeatureDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.UPDATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        PlanFeature qentity = new QPlanFeature().where().id.equalTo(input.getId()).findOne();

        if (qentity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(PlanFeatureValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }


        PlanFeature PlanFeature = PlanFeatureMapper.INSTANCE.mergeInputAndEntity(qentity, input);

        //Flush to database
        PlanFeature.update();

        //Set response
        result = PlanFeatureMapper.INSTANCE.entityToDto(PlanFeature);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanFeatureValidationMessage.UPDATE_SUCCESS);

        ResponseContent<PlanFeatureDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<PlanFeatureDto> deletePlanFeature(PlanFeatureInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanFeatureDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.DELETE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        PlanFeature queryEntity = new QPlanFeature().where().id.equalTo(input.getId()).findOne();

        if (queryEntity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(PlanFeatureValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }

        PlanFeature PlanFeature = PlanFeatureMapper.INSTANCE.mergeInputAndEntity(queryEntity, input);
        PlanFeature.setSoftDelete(true);

        //Flush to database
        PlanFeature.update();

        //Set response
        result = PlanFeatureMapper.INSTANCE.entityToDto(PlanFeature);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanFeatureValidationMessage.DELETE_SUCCESS);

        ResponseContent<PlanFeatureDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<PlanFeatureDto> createPlanFeature(PlanFeatureInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        PlanFeatureDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.CREATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }
        PlanFeature PlanFeature = PlanFeatureMapper.INSTANCE.inputToEntity(input);


        //Flush to database
        PlanFeature.save();

        //Set response
        result = PlanFeatureMapper.INSTANCE.entityToDto(PlanFeature);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(PlanFeatureValidationMessage.CREATE_SUCCESS);

        ResponseContent<PlanFeatureDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }
}
