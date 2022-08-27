package com.backend_connect_casestudy.repository.contract;

import com.backend_connect_casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Query(value = "select * from contract_detail where id = :id", nativeQuery = true)
    ContractDetail findById(@Param("id") int id);

    @Query(value = "select * from contract_detail where contract_id = :id",nativeQuery = true)
    List<ContractDetail> fillAllByContractId(@Param("id") int id);
}
