package com.final_exam_codegym_api.repository;

import com.final_exam_codegym_api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer > {

    @Query(value = "select * from customer",nativeQuery = true)
    List<Customer> findAll();
}
