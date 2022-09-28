package com.final_exam_codegym_api.service;

import com.final_exam_codegym_api.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
