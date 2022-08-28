package com.back_end_final_module5_2.rest_controller;


import com.back_end_final_module5_2.model.Patient;
import com.back_end_final_module5_2.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/patient")
public class PatientRestController {

    @Autowired
    private IPatientService iPatientService;

    @GetMapping("/searchList")
    public ResponseEntity<Page<Patient>> findPatientByNamePatient(@PageableDefault(value = 5)Pageable pageable,
                                                                  @RequestParam Optional<String> name){
        String keywordName = name.orElse("");
        Page<Patient> patientPage = iPatientService.findAllByNamePatient(keywordName,pageable);
        return new ResponseEntity<>(patientPage, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id){
        Optional<Patient> patientOptional = iPatientService.findById(id);
        if (!patientOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patientOptional.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return new ResponseEntity<>(iPatientService.save(patient),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient,
                                                 @PathVariable String id){
        patient.setIdPatient(id);
        return new ResponseEntity<>(iPatientService.save(patient),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deleteFacility(@PathVariable String id) {
         iPatientService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
