package com.sprint2_api.rest_controller;


import com.sprint2_api.model.Bill;
import com.sprint2_api.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/bill")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillRestController {

    @Autowired
    private IBillService iBillService;

    @PostMapping("/create")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
            iBillService.save(bill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
