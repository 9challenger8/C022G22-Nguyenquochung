package com.final_exam_codegym_api.rest_controller;

import com.final_exam_codegym_api.model.Facility;
import com.final_exam_codegym_api.model.Manager;
import com.final_exam_codegym_api.service.IFacilityService;
import com.final_exam_codegym_api.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/manager")
public class ManagerRestController {

    @Autowired
    private IManagerService iManagerService;

    @GetMapping("/list")
    public ResponseEntity<List<Manager>> getAllEmployee() {
        return new ResponseEntity<>(iManagerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Manager> getFacilityById(@PathVariable Integer id) {
        Optional<Manager> managerOptional = iManagerService.searchById(id);
        if (!managerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(managerOptional.get(), HttpStatus.OK);
    }

}
