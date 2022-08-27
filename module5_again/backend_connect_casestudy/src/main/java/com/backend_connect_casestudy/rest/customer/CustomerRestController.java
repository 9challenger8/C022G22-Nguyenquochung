package com.backend_connect_casestudy.rest.customer;

import com.backend_connect_casestudy.model.customer.Customer;
import com.backend_connect_casestudy.model.facility.Facility;
import com.backend_connect_casestudy.service.ICustomerService;
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
@RequestMapping(value = "/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = iCustomerService.findAll();
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/searchList")
    public ResponseEntity< Page<Customer>> findCustomerByNamePagination(@PageableDefault(value = 6) Pageable pageable,
                                                                        @RequestParam Optional<String> name) {
        String keywordName = name.orElse("");
        Page<Customer> customerPage = iCustomerService.findAllByName('%'+keywordName+'%', pageable);
        if (customerPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Customer> getDetailFacilityById(@PathVariable Integer id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> saveFacility(@RequestBody Customer customer) {
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateFacility(@RequestBody Customer customer, @PathVariable int id) {
        customer.setId(id);
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Facility> deleteFacility(@PathVariable int id) {
        iCustomerService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
