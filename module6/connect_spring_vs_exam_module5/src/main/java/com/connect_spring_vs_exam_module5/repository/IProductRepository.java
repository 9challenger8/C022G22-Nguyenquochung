package com.connect_spring_vs_exam_module5.repository;

import com.connect_spring_vs_exam_module5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {





}
