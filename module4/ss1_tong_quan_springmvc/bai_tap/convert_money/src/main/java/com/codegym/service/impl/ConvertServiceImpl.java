package com.codegym.service.impl;

import com.codegym.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public int convert(int a) {
        return 22000*a;
    }
}
