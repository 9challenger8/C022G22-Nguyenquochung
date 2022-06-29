package com.codegym.them_san_pham_vao_gio_hang.service;

import com.codegym.them_san_pham_vao_gio_hang.model.Product;
import com.codegym.them_san_pham_vao_gio_hang.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
