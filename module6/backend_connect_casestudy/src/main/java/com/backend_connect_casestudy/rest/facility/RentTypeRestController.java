package com.backend_connect_casestudy.rest.facility;


import com.backend_connect_casestudy.model.facility.RentType;
import com.backend_connect_casestudy.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentType")
@CrossOrigin(origins = "http://localhost:4200")
public class RentTypeRestController {

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<RentType>> getListRentType(){
        List<RentType> rentTypeList = iRentTypeService.findAll();
        return new ResponseEntity<>(rentTypeList, HttpStatus.OK);
    }

}
