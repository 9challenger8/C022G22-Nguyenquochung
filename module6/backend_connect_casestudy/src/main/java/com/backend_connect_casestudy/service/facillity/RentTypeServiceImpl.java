package com.backend_connect_casestudy.service.facillity;

import com.backend_connect_casestudy.model.facility.RentType;
import com.backend_connect_casestudy.repository.facility.IRentTypeRepository;
import com.backend_connect_casestudy.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }


}
