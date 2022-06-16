package com.service.impl;

import com.service.ICalculatorService;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public double div(int a, int b) {
        return a/b;
    }
}
