package com.connect_spring_vs_exam_module5.rest;


import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import com.connect_spring_vs_exam_module5.service.ISeriesProductService;
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
@RequestMapping("/seriesProduct")
public class SeriesProductRestController {

    @Autowired
    private ISeriesProductService iSeriesProductService;

    @GetMapping("/list")
    public ResponseEntity<Page<SeriesProduct>> getAllSeriesProductPagination(@PageableDefault(value = 2) Pageable pageable){
        Page<SeriesProduct> seriesProductPage=iSeriesProductService.findAll(pageable);
        if(seriesProductPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seriesProductPage, HttpStatus.OK);
    }

    @GetMapping("/searchList")
    public ResponseEntity<Page<SeriesProduct>> findSeriesProductByIdPagination(@PageableDefault(value = 3) Pageable pageable,
                                                                               @RequestParam Optional<String> id){
        String keywordId = id.orElse("");
        Page<SeriesProduct> seriesProductPage=iSeriesProductService.findSeriesProductById(keywordId,pageable);
        if(seriesProductPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seriesProductPage,HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SeriesProduct> getDetailSeriesProductById(@PathVariable String id){
        Optional<SeriesProduct> seriesProductOptional = iSeriesProductService.getById(id);
        if(!seriesProductOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seriesProductOptional.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SeriesProduct> saveSeriesProduct(@RequestBody SeriesProduct seriesProduct){
        return new ResponseEntity<>(iSeriesProductService.save(seriesProduct),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SeriesProduct> updateSeriesProduct(@RequestBody SeriesProduct seriesProduct,@PathVariable String id){
        seriesProduct.setId(id);
        return new ResponseEntity<>(iSeriesProductService.save(seriesProduct),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SeriesProduct> deleteSeriesProduct(@PathVariable String id){
        iSeriesProductService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
