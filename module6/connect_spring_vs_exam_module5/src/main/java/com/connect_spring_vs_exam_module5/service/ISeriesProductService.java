package com.connect_spring_vs_exam_module5.service;


import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISeriesProductService {

    Optional<SeriesProduct> getById(String id);

    void removeById(String id);

    SeriesProduct save(SeriesProduct seriesProduct);

//    Page<SeriesProduct> findAllByName(String name, Pageable pageable);

    Page<SeriesProduct> findAll(Pageable pageable);


}
