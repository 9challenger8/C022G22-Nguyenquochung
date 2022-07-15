package com.case_study_module4.rest.contract;

import com.case_study_module4.model.contract.AttachFacility;
import com.case_study_module4.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/restContract")
public class AttachFacilityRestController {

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/list")
    public ResponseEntity<List<AttachFacility>> getListAttachFacility(){
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
    }
}
