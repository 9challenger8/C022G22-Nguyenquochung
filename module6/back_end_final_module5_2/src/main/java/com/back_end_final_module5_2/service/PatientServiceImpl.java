package com.back_end_final_module5_2.service;

import com.back_end_final_module5_2.model.Patient;
import com.back_end_final_module5_2.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository iPatientRepository;

    @Override
    public Optional<Patient> findById(String id) {
        return iPatientRepository.findById(id);
    }

    @Override
    public void removeById(String id) {
        iPatientRepository.removeById(id);
    }

    @Override
    public Page<Patient> findAllByNamePatient(String namePatient, Pageable pageable) {
        return iPatientRepository.findAllByNamePatient(namePatient,pageable);
    }

    @Override
    public Patient save(Patient patient) {
        return iPatientRepository.save(patient);
    }
}
