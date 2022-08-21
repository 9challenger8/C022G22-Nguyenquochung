package com.backend_connect_casestudy.service.contract;

import com.backend_connect_casestudy.model.contract.AttachFacility;
import com.backend_connect_casestudy.repository.contract.IAttachFacilityRepository;
import com.backend_connect_casestudy.service.IAttachFacilityService;
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
