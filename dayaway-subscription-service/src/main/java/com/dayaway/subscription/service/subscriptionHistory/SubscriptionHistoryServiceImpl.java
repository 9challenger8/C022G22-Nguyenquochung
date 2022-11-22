package com.dayaway.subscription.service.subscriptionHistory;

import com.dayaway.subscription.core.common.Filter;
import com.dayaway.subscription.core.graphql.ResponseContent;
import com.dayaway.subscription.core.graphql.ResponseContentStatusEnum;
import com.dayaway.subscription.core.graphql.ResponseData;
import com.dayaway.subscription.core.utils.EbeanUtils;
import com.dayaway.subscription.core.validation.ActionTypeEnum;
import com.dayaway.subscription.core.validation.ValidationMessage;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryDto;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryFilter;
import com.dayaway.subscription.dto.subscriptionHistory.SubscriptionHistoryInput;
import com.dayaway.subscription.entity.subscriptionHistory.SubscriptionHistory;
import com.dayaway.subscription.entity.subscriptionHistory.query.QSubscriptionHistory;
import com.dayaway.subscription.validation.subscriptionHistory.SubscriptionHistoryValidationMessage;
import com.dayaway.subscription.validation.subscriptionHistory.SubscriptionHistoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionHistoryServiceImpl implements SubscriptionHistoryService {

    @Autowired
    private SubscriptionHistoryValidator validator;

    @Override
    public ResponseData<SubscriptionHistoryDto> subscriptionHistoryList(SubscriptionHistoryFilter filter) {
        filter = Filter.setDefaultValue(filter, SubscriptionHistoryFilter.class);
        QSubscriptionHistory query = new QSubscriptionHistory().where();


        //Filter query
        EbeanUtils.setEqualOrInQuery(query.id, filter.getIdList());
        EbeanUtils.setEqualOrInQuery(query.subscriptionId, filter.getSubscriptionIdList());
        EbeanUtils.setEqualOrInQuery(query.paymentStatus, filter.getPaymentStatusList());
        EbeanUtils.setEqualOrInQuery(query.paymentAmount, filter.getPaymentAmountList());
        if (filter.getPaymentDate() != null) {
            query.paymentDate.greaterOrEqualTo(filter.getPaymentDate());
        }
        if (filter.getPeriodStartDate() != null) {
            query.periodStartDate.greaterOrEqualTo(filter.getPeriodStartDate());
        }
        //Filter query - End

        //Find result
        ResponseData<SubscriptionHistory> entityList = EbeanUtils.queryEntity(query, filter);
        ResponseData<SubscriptionHistoryDto> responseData = new ResponseData(entityList, SubscriptionHistoryMapper.INSTANCE.entityToDto(entityList.getData()));
        return responseData;
    }

    @Override
    public ResponseContent<SubscriptionHistoryDto> updateSubscriptionHistory(SubscriptionHistoryInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        SubscriptionHistoryDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.UPDATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        SubscriptionHistory qentity = new QSubscriptionHistory().where().id.equalTo(input.getId()).findOne();

        if (qentity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(SubscriptionHistoryValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }


        SubscriptionHistory SubscriptionHistory = SubscriptionHistoryMapper.INSTANCE.mergeInputAndEntity(qentity, input);

        //Flush to database
        SubscriptionHistory.update();

        //Set response
        result = SubscriptionHistoryMapper.INSTANCE.entityToDto(SubscriptionHistory);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(SubscriptionHistoryValidationMessage.UPDATE_SUCCESS);

        ResponseContent<SubscriptionHistoryDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<SubscriptionHistoryDto> deleteSubscriptionHistory(SubscriptionHistoryInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        SubscriptionHistoryDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.DELETE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }


        SubscriptionHistory queryEntity = new QSubscriptionHistory().where().id.equalTo(input.getId()).findOne();

        if (queryEntity == null) {
            status = ResponseContentStatusEnum.ERROR;
            resultMessage = new ValidationMessage(SubscriptionHistoryValidationMessage.NOT_FOUND);
            return new ResponseContent<>(resultMessage, status, null);
        }

        SubscriptionHistory SubscriptionHistory = SubscriptionHistoryMapper.INSTANCE.mergeInputAndEntity(queryEntity, input);
        SubscriptionHistory.setSoftDelete(true);

        //Flush to database
        SubscriptionHistory.update();

        //Set response
        result = SubscriptionHistoryMapper.INSTANCE.entityToDto(SubscriptionHistory);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(SubscriptionHistoryValidationMessage.DELETE_SUCCESS);

        ResponseContent<SubscriptionHistoryDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }

    @Override
    public ResponseContent<SubscriptionHistoryDto> createSubscriptionHistory(SubscriptionHistoryInput input) {
        ResponseContentStatusEnum status = ResponseContentStatusEnum.DEFAULT;
        SubscriptionHistoryDto result = null;
        //Validation input
        ValidationMessage resultMessage = validator.validateEntity(input, ActionTypeEnum.CREATE);
        if (!resultMessage.getSuccess()) {
            status = ResponseContentStatusEnum.ERROR;
            return new ResponseContent<>(resultMessage, status, null);
        }
        SubscriptionHistory subscriptionHistory = SubscriptionHistoryMapper.INSTANCE.inputToEntity(input);


        //Flush to database
        subscriptionHistory.save();

        //Set response
        result = SubscriptionHistoryMapper.INSTANCE.entityToDto(subscriptionHistory);
        status = ResponseContentStatusEnum.SUCCESS;
        resultMessage = new ValidationMessage(SubscriptionHistoryValidationMessage.CREATE_SUCCESS);

        ResponseContent<SubscriptionHistoryDto> responseContent = new ResponseContent<>(resultMessage, status, result);
        return responseContent;
    }
}
