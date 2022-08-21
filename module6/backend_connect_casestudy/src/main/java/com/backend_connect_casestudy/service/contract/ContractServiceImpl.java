package com.backend_connect_casestudy.service.contract;

import com.backend_connect_casestudy.model.contract.Contract;
import com.backend_connect_casestudy.repository.contract.IContractRepository;
import com.backend_connect_casestudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAllByNameCustomer(String nameCustomer, Pageable pageable) {
        return iContractRepository.findAllByNameCustomer(nameCustomer,pageable);
    }

    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id);
    }

    @Override
    public Contract save(Contract contract) {
        return iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}
