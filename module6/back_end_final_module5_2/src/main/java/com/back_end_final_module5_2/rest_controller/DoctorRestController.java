package com.back_end_final_module5_2.rest_controller;


import com.back_end_final_module5_2.model.Doctor;
import com.back_end_final_module5_2.service.IDoctorService;
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
@RequestMapping(value = "/doctor")
public class DoctorRestController {

    @Autowired
    private IDoctorService iDoctorService;

    @GetMapping("/list")
    public ResponseEntity<List<Doctor>> getListDoctor(){
        List<Doctor> doctorList = iDoctorService.findAll();
        return new ResponseEntity<>(doctorList, HttpStatus.OK);
    }

}
