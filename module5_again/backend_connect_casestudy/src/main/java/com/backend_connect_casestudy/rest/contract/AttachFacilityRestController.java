package com.backend_connect_casestudy.rest.contract;

import com.backend_connect_casestudy.model.contract.AttachFacility;
import com.backend_connect_casestudy.service.IAttachFacilityService;
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
@RequestMapping("/attachFacility")
public class AttachFacilityRestController {

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("/list")
    public ResponseEntity<List<AttachFacility>> getListAttachFacility(){
        List<AttachFacility> attachFacilityList = iAttachFacilityService.findAll();
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
}
