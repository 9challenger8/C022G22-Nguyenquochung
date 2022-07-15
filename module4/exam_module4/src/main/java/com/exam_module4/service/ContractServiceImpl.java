package com.exam_module4.service;

import com.exam_module4.model.Contract;
import com.exam_module4.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService{

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Contract findById(String id) {
        return iContractRepository.findById(id) ;
    }

    @Override
    public void removeById(String id) {
        iContractRepository.removeById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}
