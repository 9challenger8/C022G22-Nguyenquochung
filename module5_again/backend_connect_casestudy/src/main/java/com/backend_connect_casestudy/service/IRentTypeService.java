package com.backend_connect_casestudy.service;

import com.backend_connect_casestudy.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
