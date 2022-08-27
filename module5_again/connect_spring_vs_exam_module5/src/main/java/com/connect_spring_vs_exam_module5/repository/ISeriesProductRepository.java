package com.connect_spring_vs_exam_module5.repository;

import com.connect_spring_vs_exam_module5.model.SeriesProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ISeriesProductRepository extends JpaRepository<SeriesProduct,String> {

    @Query(value = "select * from series_product where id like concat('%',:id,'%')", nativeQuery = true,
                    countQuery = "select count(*) from (select * from series_product where id like concat('%',:id,'%') ) adc")
    Page<SeriesProduct> findSeriesProductById(@Param("id") String id, Pageable pageable);

}
