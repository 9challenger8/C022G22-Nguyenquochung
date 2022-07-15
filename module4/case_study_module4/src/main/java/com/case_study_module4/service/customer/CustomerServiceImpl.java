package com.case_study_module4.service.customer;

import com.case_study_module4.model.customer.Customer;
import com.case_study_module4.repository.customer.ICustomerRepository;
import com.case_study_module4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id) ;
    }

    @Override
    public void removeById(int id) {
        iCustomerRepository.removeById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        return iCustomerRepository.findAllByName(name,pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllPageable(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }
}
