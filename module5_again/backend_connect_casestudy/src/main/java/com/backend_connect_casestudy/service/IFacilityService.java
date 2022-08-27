package com.backend_connect_casestudy.service;


import com.backend_connect_casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {

    Optional<Facility> findById(Integer id) ;

    void removeById(int id);

    Facility save(Facility facility);

    Page<Facility> findAllByName(String name, Pageable pageable);

    Page<Facility> findAllPageable(Pageable pageable);

    List<Facility> findAll();

}
