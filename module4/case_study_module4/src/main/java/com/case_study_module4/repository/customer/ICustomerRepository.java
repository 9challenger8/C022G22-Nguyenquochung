package com.case_study_module4.repository.customer;


import com.case_study_module4.model.customer.Customer;
import com.case_study_module4.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where id = :id", nativeQuery = true)
    Customer findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from customer where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Query(value = "select * from customer where name like :name", nativeQuery = true,
            countQuery = "select count(*) from (select * from customer where name like :name) abc")
    Page<Customer> findAllByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select * from customer",nativeQuery = true)
    List<Customer> findAll();

}
