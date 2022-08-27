package com.backend_connect_casestudy.repository.contract;

import com.backend_connect_casestudy.model.contract.Contract;
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
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where id = :id", nativeQuery = true)
    Contract findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from contract where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Query(value = "select * from contract where start_date like :startDate", nativeQuery = true,
            countQuery = "select count(*) from (select * from contract where start_date like :startDate) abc")
    Page<Contract> findAllByStartDate(@Param("startDate") String startDate, Pageable pageable);

    @Query(value = "select contract.id,contract.deposit,contract.start_date,contract.end_date,contract.customer_id,contract.facility_id,contract.total_money from contract " +
            " join customer on contract.customer_id = customer.id " +
            "where customer.name like concat('%',:nameCustomer,'%')", nativeQuery = true,
            countQuery = "select count(*) from (select contract.id,contract.deposit,contract.start_date,contract.end_date, " +
                    " contract.customer_id,contract.facility_id,contract.total_money  from contract " +
                    "join customer on contract.customer_id = customer.id " +
                    "where customer.name like concat('%',:nameCustomer,'%')) abc")
    Page<Contract> findAllByNameCustomer(@Param("nameCustomer") String nameCustomer, Pageable pageable);

    @Query(value = "select * from contract", nativeQuery = true)
    List<Contract> findAll();
}
