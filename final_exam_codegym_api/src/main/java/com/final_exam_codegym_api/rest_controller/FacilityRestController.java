package com.final_exam_codegym_api.rest_controller;

import com.final_exam_codegym_api.dto.IFacilityDto;
import com.final_exam_codegym_api.model.Facility;
import com.final_exam_codegym_api.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/facility")
public class FacilityRestController {

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/searchList")
    public ResponseEntity<Page<IFacilityDto>> getAllListFacilityPaginationAndSearch(@PageableDefault(value = 6) Pageable pageable,
                                                                                @RequestParam Optional<String> nameFacility,
                                                                                @RequestParam Optional<String> nameManager) {
        String keywordNameFacility = nameFacility.orElse("");
        String keywordNameManager = nameManager.orElse("");
        Page<IFacilityDto> facilityPage = iFacilityService.findAllByName(keywordNameFacility, keywordNameManager, pageable);
        if (facilityPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facilityPage, HttpStatus.OK);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Facility> deleteEmployeeById(@PathVariable Integer id) {
        List<Facility> facilityList = iFacilityService.findAll();
        for (Facility facility : facilityList) {
            if (Objects.equals(id, facility.getId())) {
                iFacilityService.deleteFacility(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create")
    public ResponseEntity<Facility> saveFacility(@RequestBody Facility facility) {
        return new ResponseEntity<>(iFacilityService.save(facility), HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Integer id) {
        Optional<Facility> facilityOptional = iFacilityService.searchById(id);
        if (!facilityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facilityOptional.get(), HttpStatus.OK);
    }

}
