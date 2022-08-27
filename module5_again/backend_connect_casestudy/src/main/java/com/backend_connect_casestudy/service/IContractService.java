package com.backend_connect_casestudy.service;

import com.backend_connect_casestudy.model.contract.Contract;
import com.backend_connect_casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IContractService {
    Page<Contract> findAllByNameCustomer(String nameCustomer, Pageable pageable);

    Contract findById(int id);

    Contract save(Contract contract);

    List<Contract> findAll();
}
