package com.backend_connect_casestudy.rest.facility;

import com.backend_connect_casestudy.model.customer.Customer;
import com.backend_connect_casestudy.model.facility.Facility;
import com.backend_connect_casestudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/facility")
public class FacilityRestController {

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/listPagination")
    public ResponseEntity<Page<Facility>> getAllFacilityPagination(@PageableDefault(value = 4) Pageable pageable) {
        Page<Facility> seriesProductPage = iFacilityService.findAllPageable(pageable);
        if (seriesProductPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seriesProductPage, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Facility>> getAllFacility(){
        List<Facility> facilityList = iFacilityService.findAll();
        return new ResponseEntity<>(facilityList,HttpStatus.OK);
    }

    @GetMapping("/searchList")
    public ResponseEntity<Page<Facility>> findFacilityByNamePagination(@PageableDefault(value = 6) Pageable pageable,
                                                                       @RequestParam Optional<String> name) {
        String keywordName = name.orElse("");
        Page<Facility> facilityPage = iFacilityService.findAllByName(keywordName, pageable);
        if (facilityPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facilityPage, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Facility> getDetailFacilityById(@PathVariable Integer id) {
        Optional<Facility> facilityOptional = iFacilityService.findById(id);
        if (!facilityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facilityOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Facility> saveFacility(@RequestBody Facility facility) {
        return new ResponseEntity<>(iFacilityService.save(facility), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Facility> updateFacility(@RequestBody Facility facility, @PathVariable int id) {
        facility.setId(id);
        return new ResponseEntity<>(iFacilityService.save(facility), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Facility> deleteFacility(@PathVariable int id) {
        iFacilityService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
