package com.back_end_final_module5_2.service;

import com.back_end_final_module5_2.model.Doctor;
import com.back_end_final_module5_2.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl implements IDoctorService{

    @Autowired
    private IDoctorRepository iDoctorRepository;

    @Override
    public List<Doctor> findAll() {
        return iDoctorRepository.findAll();
    }
}
