package com.final_exam_codegym_api.service;


import com.final_exam_codegym_api.model.Manager;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IManagerService {
    List<Manager> findAll();

    Optional<Manager> searchById( Integer id);
}
