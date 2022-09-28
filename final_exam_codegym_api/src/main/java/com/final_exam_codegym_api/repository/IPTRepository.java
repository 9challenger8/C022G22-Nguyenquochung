package com.final_exam_codegym_api.repository;

import com.final_exam_codegym_api.model.Customer;
import com.final_exam_codegym_api.model.PT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPTRepository extends JpaRepository<PT, Integer> {

    @Query(value = "select * from pt", nativeQuery = true)
    List<PT> findAll();
}
