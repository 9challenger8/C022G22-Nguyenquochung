package com.backend_connect_casestudy.rest.customer;


import com.backend_connect_casestudy.model.customer.CustomerType;
import com.backend_connect_casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customerType")
public class CustomerTypeRestController {

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<CustomerType>> getListRentType(){
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }
}
