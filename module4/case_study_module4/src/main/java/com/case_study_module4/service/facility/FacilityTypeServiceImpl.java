package com.case_study_module4.service.facility;

import com.case_study_module4.model.facility.FacilityType;
import com.case_study_module4.repository.facility.IFacilityTypeRepository;
import com.case_study_module4.service.IFacilityService;
import com.case_study_module4.service.IFacilityTypeService;
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
