package com.final_exam_codegym_api.service.impl;

import com.final_exam_codegym_api.model.PT;
import com.final_exam_codegym_api.repository.IPTRepository;
import com.final_exam_codegym_api.service.IPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PTServiceImpl implements IPTService {

    @Autowired
    private IPTRepository iptRepository;

    @Override
    public List<PT> findAll() {
        return iptRepository.findAll();
    }
}
