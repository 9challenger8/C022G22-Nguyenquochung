package com.backend_connect_casestudy.service;

import com.backend_connect_casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {


    Optional<Customer> findById(Integer id) ;

    void removeById(int id);

    Customer save(Customer customer);

    Page<Customer> findAllByName(String name, Pageable pageable);

    Page<Customer> findAllPageable(Pageable pageable);

    List<Customer> findAll();
}
