package com.case_study_module4.service;

import com.case_study_module4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IContractService {

    Contract findById(@Param("id") int id) ;

    void removeById(int id);

    void save(Contract contract);

    Page<Contract> findAllByStartDate(String startDate, Pageable pageable);

    Page<Contract> findAllPageable(Pageable pageable);

}
