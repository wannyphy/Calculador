package com.example.calculador.service;

import io.corp.calculator.TracerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServices {
    @Autowired
    private TracerAPI traceAPI;

    private Integer addService(int number1, int number2) {
        int result = number1 + number2;
        traceAPI.trace(result);
        return result;
    }

    public Integer add(int number1, int number2) {
        return addService(number1, number2);
    }

    private Integer substractService(int number1, int number2) {
        int result = number1 - number2;
        traceAPI.trace(result);
        return result;
    }

    public Integer substract(int number1, int number2) {
        return substractService(number1, number2);
    }
}

