package com.case_study_module4.repository.contract;

import com.case_study_module4.model.contract.Contract;

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
public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "select * from contract where id = :id", nativeQuery = true)
    Contract findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from contract where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Query(value = "select * from contract where start_date like :startDate", nativeQuery = true,
            countQuery = "select count(*) from (select * from contract where start_date like :startDate) abc")
    Page<Contract> findAllByStartDate(@Param("startDate") String startDate, Pageable pageable);

    @Query(value = "select * from contract",nativeQuery = true)
    List<Contract> findAll();
}
