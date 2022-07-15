package com.case_study_module4.service.facility;

import com.case_study_module4.model.facility.FacilityType;
import com.case_study_module4.model.facility.RentType;
import com.case_study_module4.repository.facility.IRentTypeRepository;
import com.case_study_module4.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
