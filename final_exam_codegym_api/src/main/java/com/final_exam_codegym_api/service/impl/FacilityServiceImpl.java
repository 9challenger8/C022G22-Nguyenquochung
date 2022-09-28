package com.final_exam_codegym_api.service.impl;

import com.final_exam_codegym_api.dto.IFacilityDto;
import com.final_exam_codegym_api.model.Facility;
import com.final_exam_codegym_api.repository.IFacilityRepository;
import com.final_exam_codegym_api.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<IFacilityDto> findAllByName(String nameFacility, String nameManager, Pageable pageable) {
        return iFacilityRepository.findAllByName(nameFacility,nameManager,pageable);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Optional<Facility> searchById(Integer id) {
        return iFacilityRepository.searchById(id);
    }


    @Override
    public void removeById(Integer id) {
        iFacilityRepository.removeById(id);
    }

    @Override
    public void deleteFacility(Integer id) {
        iFacilityRepository.deleteFacility(id);
    }

    @Override
    public Facility save(Facility facility) {
        return iFacilityRepository.save(facility);
    }
}
