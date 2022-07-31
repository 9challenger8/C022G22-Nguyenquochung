package com.case_study_module4.rest.contract;


import com.case_study_module4.model.contract.ContractDetail;
import com.case_study_module4.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restContractDetail")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService iContractDetailService;


    @GetMapping("/list")
    public ResponseEntity<List<ContractDetail>> getListContractDetail(){
        List<ContractDetail> contractDetailList = iContractDetailService.findAll();
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @GetMapping("/detail/")
    public ResponseEntity<ContractDetail> getContractDetailById(@RequestParam int id ){
        return new ResponseEntity<>(iContractDetailService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<ContractDetail>> getListContractDetailByContractId(@PathVariable int id ){
        return new ResponseEntity<>(iContractDetailService.fillAllByContractId(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ContractDetail> createContractDetail(@RequestBody ContractDetail contractDetail) {
        return new ResponseEntity<>( iContractDetailService.save(contractDetail), HttpStatus.CREATED);
    }

}
