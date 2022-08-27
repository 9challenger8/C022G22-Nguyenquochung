package com.connect_spring_vs_exam_module5.service;


import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import com.connect_spring_vs_exam_module5.repository.ISeriesProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SeriesProductServiceImpl implements ISeriesProductService {

    @Autowired
    private ISeriesProductRepository iSeriesProductRepository;

    @Override
    public Optional<SeriesProduct> getById(String id) {
        return iSeriesProductRepository.findById(id);
    }

    @Override
    public void removeById(String id) {
         iSeriesProductRepository.deleteById(id);

    }

    @Override
    public SeriesProduct save(SeriesProduct seriesProduct) {
        return iSeriesProductRepository.save(seriesProduct);
    }

    @Override
    public Page<SeriesProduct> findSeriesProductById(String id, Pageable pageable) {
        return iSeriesProductRepository.findSeriesProductById(id,pageable);
    }

    @Override
    public Page<SeriesProduct> findAll(Pageable pageable) {
        return iSeriesProductRepository.findAll(pageable);
    }


}
