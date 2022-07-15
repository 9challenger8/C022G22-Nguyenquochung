package com.case_study_module4.service.contract;

import com.case_study_module4.model.contract.AttachFacility;
import com.case_study_module4.repository.contract.IAttachFacilityRepository;
import com.case_study_module4.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
