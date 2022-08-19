package com.backend_connect_casestudy.service.facillity;

import com.backend_connect_casestudy.model.facility.FacilityType;
import com.backend_connect_casestudy.repository.facility.IFacilityTypeRepository;
import com.backend_connect_casestudy.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
