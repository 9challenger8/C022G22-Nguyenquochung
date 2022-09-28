package com.final_exam_codegym_api.service.impl;

import com.final_exam_codegym_api.model.Customer;
import com.final_exam_codegym_api.repository.ICustomerRepository;
import com.final_exam_codegym_api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
