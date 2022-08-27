package com.connect_spring_vs_exam_module5.service;

import com.connect_spring_vs_exam_module5.model.Product;
import com.connect_spring_vs_exam_module5.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }
}
