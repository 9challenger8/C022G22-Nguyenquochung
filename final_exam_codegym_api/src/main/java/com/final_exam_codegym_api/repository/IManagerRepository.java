package com.final_exam_codegym_api.repository;

import com.final_exam_codegym_api.model.Facility;
import com.final_exam_codegym_api.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IManagerRepository extends JpaRepository<Manager,Integer> {

    @Query(value = "select * from manager",nativeQuery = true)
    List<Manager> findAll();

    @Query(value = "select * from manager where id = :id", nativeQuery = true)
    Optional<Manager> searchById(@Param("id") Integer id);
}
