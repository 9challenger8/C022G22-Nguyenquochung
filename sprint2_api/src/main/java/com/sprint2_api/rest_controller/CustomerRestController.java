package com.sprint2_api.rest_controller;

import com.sprint2_api.dto.IHistoryPaymentDto;
import com.sprint2_api.model.Customer;
import com.sprint2_api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("/detail/{name}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String name){
        return new ResponseEntity<>(iCustomerService.findCustomerByUsername(name), HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<List<IHistoryPaymentDto>> getHistoryPayment(@PathVariable Integer id){
        return new ResponseEntity<>(iCustomerService.getHistoryPayment(id),HttpStatus.OK);
    }
}
