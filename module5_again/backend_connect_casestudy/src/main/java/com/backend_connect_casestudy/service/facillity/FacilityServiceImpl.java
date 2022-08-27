package com.backend_connect_casestudy.service.facillity;

import com.backend_connect_casestudy.model.facility.Facility;
import com.backend_connect_casestudy.repository.facility.IFacilityRepository;
import com.backend_connect_casestudy.service.IFacilityService;
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
    public Optional<Facility> findById(Integer id) {
        return iFacilityRepository.findById(id);
    }


    @Override
    public void removeById(int id) {
        iFacilityRepository.removeById(id);
    }

    @Override
    public Facility save(Facility facility) {
        return iFacilityRepository.save(facility);
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
