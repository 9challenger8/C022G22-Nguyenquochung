package com.backend_connect_casestudy.service;

import com.backend_connect_casestudy.model.contract.ContractDetail;
import com.backend_connect_casestudy.model.facility.Facility;

import java.util.List;

public interface IContractDetailService {

    ContractDetail findById(int id);

    List<ContractDetail> fillAllByContractId(int id);

    ContractDetail save(ContractDetail contractDetail);

}
