package com.connect_spring_vs_exam_module5.service;


import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import com.connect_spring_vs_exam_module5.repository.ISeriesProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SeriesProductServiceImpl implements ISeriesProductService {

    @Autowired
    private ISeriesProductRepository iSeriesProductRepository;

    @Override
    public SeriesProduct findById(String id) {
        return iSeriesProductRepository.getById(id);
    }

    @Override
    public void removeById(String id) {
        iSeriesProductRepository.deleteById(id);

    }

    @Override
    public void save(SeriesProduct seriesProduct) {
        iSeriesProductRepository.save(seriesProduct);

    }

    @Override
    public Page<SeriesProduct> findAll(Pageable pageable) {
        return iSeriesProductRepository.findAll(pageable);
    }


}
