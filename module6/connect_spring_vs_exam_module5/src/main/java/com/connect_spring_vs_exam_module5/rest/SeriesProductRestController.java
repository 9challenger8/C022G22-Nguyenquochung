package com.connect_spring_vs_exam_module5.rest;


import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import com.connect_spring_vs_exam_module5.service.ISeriesProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesProductRestController {

    @Autowired
    private ISeriesProductService iSeriesProductService;

    @GetMapping("/list")
    public ResponseEntity<Page<SeriesProduct>> getAllSeriesProduct(Pageable pageable){
        Page<SeriesProduct> seriesProductList=iSeriesProductService.findAll(pageable);
        return new ResponseEntity<>(seriesProductList, HttpStatus.OK);
    }





}
