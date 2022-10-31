package com.sprint2_api.service.impl;

import com.sprint2_api.dto.IHistoryPaymentDto;
import com.sprint2_api.model.Customer;

import com.sprint2_api.repository.ICustomerRepository;
import com.sprint2_api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findCustomerByUsername(String name) {
        return iCustomerRepository.findCustomerByUsername(name);
    }

    @Override
    public List<IHistoryPaymentDto> getHistoryPayment(Integer id) {
        return iCustomerRepository.getHistoryPayment(id);
    }
}
