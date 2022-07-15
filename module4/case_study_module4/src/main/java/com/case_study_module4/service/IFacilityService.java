package com.case_study_module4.service;

import com.case_study_module4.model.customer.Customer;
import com.case_study_module4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService {

    Facility findById( int id) ;

    void removeById(int id);

    void save(Facility facility);

    Page<Facility> findAllByName(String name, Pageable pageable);

    Page<Facility> findAllPageable(Pageable pageable);

    List<Facility> findAll();

}
