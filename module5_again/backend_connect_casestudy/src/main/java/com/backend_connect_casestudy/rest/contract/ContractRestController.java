package com.backend_connect_casestudy.rest.contract;


import com.backend_connect_casestudy.model.contract.Contract;
import com.backend_connect_casestudy.service.IContractService;
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
@RequestMapping("/contract")
public class ContractRestController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/searchList")
    public ResponseEntity<Page<Contract>> findFacilityByNamePagination(@PageableDefault(value = 6) Pageable pageable,
                                                                       @RequestParam Optional<String> name) {
        String keywordName = name.orElse("");
        Page<Contract> contractPage = iContractService.findAllByNameCustomer(keywordName, pageable);
        if (contractPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Contract> saveFacility(@RequestBody Contract contract) {
        return new ResponseEntity<>(iContractService.save(contract), HttpStatus.CREATED);
    }
}
