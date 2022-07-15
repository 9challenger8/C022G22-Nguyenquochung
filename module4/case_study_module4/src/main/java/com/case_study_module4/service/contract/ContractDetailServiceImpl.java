package com.case_study_module4.service.contract;

import com.case_study_module4.model.contract.ContractDetail;
import com.case_study_module4.repository.contract.IContractDetailRepository;
import com.case_study_module4.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return iContractDetailRepository.findById(id);
    }

    @Override
    public List<ContractDetail> fillAllByContractId(int id) {
        return iContractDetailRepository.fillAllByContractId(id);
    }
}
