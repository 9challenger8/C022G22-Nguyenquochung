package com.demo.service;

import com.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);
}
