package com.sprint2_api.service;

import com.sprint2_api.dto.IHistoryPaymentDto;
import com.sprint2_api.model.Customer;

import java.util.List;


public interface ICustomerService {
    Customer findCustomerByUsername(String name);

    List<IHistoryPaymentDto> getHistoryPayment(Integer id);
}
