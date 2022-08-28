package com.back_end_final_module5_2.repository;

import com.back_end_final_module5_2.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(value = "select * from doctor",nativeQuery = true)
    List<Doctor> findAll();
}
