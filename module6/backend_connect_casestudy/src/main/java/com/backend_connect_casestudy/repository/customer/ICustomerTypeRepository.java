package com.backend_connect_casestudy.repository.customer;

import com.backend_connect_casestudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

    @Query(value = "select * from customer_type",nativeQuery = true)
    List<CustomerType> findAll();
}
