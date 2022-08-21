package com.backend_connect_casestudy.service;

import com.backend_connect_casestudy.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();
}

