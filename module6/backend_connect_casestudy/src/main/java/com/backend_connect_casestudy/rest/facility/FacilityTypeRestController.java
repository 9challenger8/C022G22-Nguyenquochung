package com.backend_connect_casestudy.rest.facility;


import com.backend_connect_casestudy.model.facility.FacilityType;
import com.backend_connect_casestudy.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/facilityType")
public class FacilityTypeRestController {

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<FacilityType>> getListRentType(){
        List<FacilityType> facilityTypeList = iFacilityTypeService.findAll();
        return new ResponseEntity<>(facilityTypeList, HttpStatus.OK);
    }
}
