package com.connect_spring_vs_exam_module5.service;

import com.connect_spring_vs_exam_module5.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
}
