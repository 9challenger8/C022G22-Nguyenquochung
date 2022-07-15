package com.case_study_module4.repository.contract;

import com.case_study_module4.model.contract.ContractDetail;
import com.case_study_module4.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Query(value = "select * from contract_detail where id = :id", nativeQuery = true)
    ContractDetail findById(@Param("id") int id);

    @Query(value = "select * from contract_detail where contract_id = :id",nativeQuery = true)
    List<ContractDetail> fillAllByContractId(@Param("id") int id);
}
