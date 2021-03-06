package com.case_study_module4.service;

import com.case_study_module4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {

    Customer findById(@Param("id") int id) ;

    void removeById(int id);

    void save(Customer customer);

    Page<Customer> findAllByName(String name, Pageable pageable);

    Page<Customer> findAllPageable(Pageable pageable);

    List<Customer> findAll();
}
