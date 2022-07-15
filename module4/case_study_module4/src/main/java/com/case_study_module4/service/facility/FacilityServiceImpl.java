package com.case_study_module4.service.facility;

import com.case_study_module4.model.facility.Facility;
import com.case_study_module4.repository.facility.IFacilityRepository;
import com.case_study_module4.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Facility findById(int id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void removeById(int id) {
        iFacilityRepository.removeById(id);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Page<Facility> findAllByName(String name, Pageable pageable) {
        return iFacilityRepository.findAllByName(name,pageable);
    }

    @Override
    public Page<Facility> findAllPageable(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }
}
