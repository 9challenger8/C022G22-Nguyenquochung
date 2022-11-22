package com.dayaway.subscription.service.subscription;

import com.dayaway.subscription.core.common.Filter;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseContentStatusEnum;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.core.utils.EbeanUtils;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.ValidationMessage;
import com.dayaway.subscription.dto.subscription.SubscriptionDto;
import com.dayaway.subscription.dto.subscription.SubscriptionFilter;
import com.dayaway.subscription.dto.subscription.SubscriptionInput;
import com.dayaway.subscription.entity.subscription.Subscription;
import com.dayaway.subscription.entity.subscription.query.QSubscription;
import com.dayaway.subscription.validation.subscription.SubscriptionValidationMessage;
import com.dayaway.subscription.validation.subscription.SubscriptionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionValidator validator;

    @Override
    public ResponseData<SubscriptionDto> subscriptionList(SubscriptionFilter filter) {
        filter = Filter.setDefaultValue(filter, SubscriptionFilter.class);

        QSubscription query = new QSubscription().where();


        //Filter query
        EbeanUtils.setEqualOrInQuery(query.id, filter.getIdList());
        EbeanUtils.setEqualOrInQuery(query.status, filter.getStatusList());
        EbeanUtils.setEqualOrInQuery(query.planId, filter.getPlanIdList());
        EbeanUtils.setEqualOrInQuery(query.autoRenewEnabled, filter.getAutoRenewEnabledList());
        EbeanUtils.setEqualOrInQuery(query.relatedType, filter.getRelatedTypeList());
        EbeanUtils.setEqualOrInQuery(query.relatedId, filter.getRelatedIdList());

        if (filter.getStartDate() != null) {
            query.startDate.greaterOrEqualTo(filter.getStartDate());
        }
        if (filter.getEndDate() != null) {
            query.endDate.greaterOrEqualTo(filter.getEndDate());
        }


        //Filter query - End

        //Find result
        ResponseData<Subscription> entityList = EbeanUtils.queryEntity(query, filter);
        ResponseData<SubscriptionDto> responseData = new ResponseData(entityList, SubscriptionMapper.INSTANCE.entityToDto(entityList.getData()));
        return responseData;
    }

    @Override
    public ResponseContent<SubscriptionDto> updateSubscription(SubscriptionInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        SubscriptionDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.UPDATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        Subscription qentity = new QSubscription().where().id.equalTo(input.getId()).findOne();

        if (qentity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(SubscriptionValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }


        Subscription Subscription = SubscriptionMapper.INSTANCE.mergeInputAndEntity(qentity, input);

        //Flush to database
        Subscription.update();

        //Set response
        result = SubscriptionMapper.INSTANCE.entityToDto(Subscription);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(SubscriptionValidationMessage.UPDATE_SUCCESS);

        ResponseContent<SubscriptionDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<SubscriptionDto> deleteSubscription(SubscriptionInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        SubscriptionDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.DELETE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        Subscription queryEntity = new QSubscription().where().id.equalTo(input.getId()).findOne();

        if (queryEntity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(SubscriptionValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }

        Subscription Subscription = SubscriptionMapper.INSTANCE.mergeInputAndEntity(queryEntity, input);
        Subscription.setSoftDelete(true);

        //Flush to database
        Subscription.update();

        //Set response
        result = SubscriptionMapper.INSTANCE.entityToDto(Subscription);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(SubscriptionValidationMessage.DELETE_SUCCESS);

        ResponseContent<SubscriptionDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<SubscriptionDto> createSubscription(SubscriptionInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        SubscriptionDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.CREATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }
        Subscription subscription = SubscriptionMapper.INSTANCE.inputToEntity(input);


        //Flush to database
        subscription.save();

        //Set response
        result = SubscriptionMapper.INSTANCE.entityToDto(subscription);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(SubscriptionValidationMessage.CREATE_SUCCESS);

        ResponseContent<SubscriptionDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }
}
