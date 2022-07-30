package com.connect_spring_vs_exam_module5.rest;


import com.connect_spring_vs_exam_module5.model.Product;
import com.connect_spring_vs_exam_module5.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getListProduct(){
        List<Product> productList=iProductService.findAll();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }


}
