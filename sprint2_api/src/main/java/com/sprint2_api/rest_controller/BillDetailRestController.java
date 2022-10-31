package com.sprint2_api.rest_controller;


import com.sprint2_api.model.BillDetail;
import com.sprint2_api.service.IBillDetailService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/billDetail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillDetailRestController {

    private final IBillDetailService iBillDetailServiceService;

    public BillDetailRestController(IBillDetailService iBillDetailServiceService) {
        this.iBillDetailServiceService = iBillDetailServiceService;
    }

    @PostMapping("/create")
    public ResponseEntity<BillDetail> createBillDetail(@RequestBody BillDetail billDetail){
        iBillDetailServiceService.save(billDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
