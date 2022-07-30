package com.connect_spring_vs_exam_module5.service;


import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISeriesProductService {

    SeriesProduct findById (String id);

    void removeById(String id);

    void save(SeriesProduct seriesProduct);

//    Page<SeriesProduct> findAllByName(String name, Pageable pageable);

    Page<SeriesProduct> findAll(Pageable pageable);


}
