package com.backend_connect_casestudy.rest.contract;



import com.backend_connect_casestudy.model.contract.ContractDetail;
import com.backend_connect_casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contractDetail")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService iContractDetailService;


    @GetMapping("/listById/{id}")
    public ResponseEntity<List<ContractDetail>> getListContractDetailByContractId(@PathVariable Integer id){
       List<ContractDetail> contractDetailList =  iContractDetailService.fillAllByContractId(id);
       return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ContractDetail> saveFacility(@RequestBody ContractDetail contractDetail) {
        return new ResponseEntity<>(iContractDetailService.save(contractDetail), HttpStatus.CREATED);
    }
}
