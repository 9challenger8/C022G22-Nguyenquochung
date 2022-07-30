package com.connect_spring_vs_exam_module5.repository;

import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISeriesProductRepository extends JpaRepository<SeriesProduct,String> {
}
