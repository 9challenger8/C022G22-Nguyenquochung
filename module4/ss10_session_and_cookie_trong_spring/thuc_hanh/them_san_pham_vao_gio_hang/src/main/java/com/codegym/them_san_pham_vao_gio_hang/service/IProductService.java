package com.codegym.them_san_pham_vao_gio_hang.service;

import com.codegym.them_san_pham_vao_gio_hang.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
