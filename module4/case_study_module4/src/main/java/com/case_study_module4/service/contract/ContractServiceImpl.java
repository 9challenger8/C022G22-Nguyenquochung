package com.case_study_module4.service.contract;

import com.case_study_module4.model.contract.Contract;
import com.case_study_module4.repository.contract.IContractRepository;
import com.case_study_module4.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void removeById(int id) {
        iContractRepository.removeById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAllByStartDate(String startDate, Pageable pageable) {
        return iContractRepository.findAllByStartDate(startDate,pageable);
    }

    @Override
    public Page<Contract> findAllPageable(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }
}
