package com.backend_connect_casestudy.service.customer;

import com.backend_connect_casestudy.model.customer.Customer;
import com.backend_connect_casestudy.repository.customer.ICustomerRepository;
import com.backend_connect_casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void removeById(int id) {
        iCustomerRepository.removeById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        return iCustomerRepository.findAllByName(name, pageable);
    }

    @Override
    public Page<Customer> findAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
