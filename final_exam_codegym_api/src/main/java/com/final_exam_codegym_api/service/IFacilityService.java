package com.final_exam_codegym_api.service;

import com.final_exam_codegym_api.dto.IFacilityDto;
import com.final_exam_codegym_api.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {

    Page<IFacilityDto> findAllByName(String nameFacility,
                                     String nameManager,
                                     Pageable pageable);

    List<Facility> findAll();

    Optional<Facility> searchById(Integer id);

    void removeById(Integer id);

    void deleteFacility(Integer id);

    Facility save(Facility facility);
}
