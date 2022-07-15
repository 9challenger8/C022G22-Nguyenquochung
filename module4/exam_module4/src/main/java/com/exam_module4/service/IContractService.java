package com.exam_module4.service;

import com.exam_module4.model.Contract;

import java.util.List;

public interface IContractService {

    Contract findById(String id) ;

    void removeById(String id);

    void save(Contract contract);

    List<Contract> findAll();
}
