package com.codegym.them_san_pham_vao_gio_hang.repository;

import com.codegym.them_san_pham_vao_gio_hang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

}
