package com.backend_connect_casestudy.service;

import com.backend_connect_casestudy.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}
