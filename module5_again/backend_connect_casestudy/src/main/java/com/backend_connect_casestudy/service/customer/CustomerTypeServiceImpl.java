package com.backend_connect_casestudy.service.customer;

import com.backend_connect_casestudy.model.customer.CustomerType;
import com.backend_connect_casestudy.repository.customer.ICustomerTypeRepository;
import com.backend_connect_casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
