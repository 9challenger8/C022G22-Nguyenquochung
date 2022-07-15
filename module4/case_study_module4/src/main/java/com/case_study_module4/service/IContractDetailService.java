package com.case_study_module4.service;

import com.case_study_module4.model.contract.ContractDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailService {

    ContractDetail save(ContractDetail contractDetail);

    List<ContractDetail> findAll();

    ContractDetail findById(int id);
    List<ContractDetail> fillAllByContractId( int id);
}
