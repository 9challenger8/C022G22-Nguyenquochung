package com.final_exam_codegym_api.service.impl;

import com.final_exam_codegym_api.model.Manager;
import com.final_exam_codegym_api.repository.IManagerRepository;
import com.final_exam_codegym_api.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private IManagerRepository iManagerRepository;

    @Override
    public List<Manager> findAll() {
        return iManagerRepository.findAll();
    }

    @Override
    public Optional<Manager> searchById(Integer id) {
        return iManagerRepository.searchById(id);
    }
}
