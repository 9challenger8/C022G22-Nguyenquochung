package com.backend_connect_casestudy.service.contract;

import com.backend_connect_casestudy.model.contract.ContractDetail;
import com.backend_connect_casestudy.repository.contract.IContractDetailRepository;
import com.backend_connect_casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public ContractDetail findById(int id) {
        return iContractDetailRepository.findById(id);
    }

    @Override
    public List<ContractDetail> fillAllByContractId(int id) {
        return iContractDetailRepository.fillAllByContractId(id);
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return iContractDetailRepository.save(contractDetail);
    }
}
