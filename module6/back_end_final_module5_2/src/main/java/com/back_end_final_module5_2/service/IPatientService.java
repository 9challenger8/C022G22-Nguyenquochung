package com.back_end_final_module5_2.service;

import com.back_end_final_module5_2.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPatientService {
    Optional<Patient> findById(String id);

    void removeById(String id);

    Page<Patient> findAllByNamePatient(String namePatient, Pageable pageable);

    Patient save(Patient patient);
}
