package com.example.calculador.service;


import com.example.calculador.config.AppConfig;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServices {

    private AppConfig traceAPI=new AppConfig();

    private BigDecimal addService(BigDecimal number1, BigDecimal number2) {
        BigDecimal result = number1.add(number2);
        traceAPI.tracerAPI().trace(result);
        return result;
    }

    public BigDecimal add(BigDecimal number1, BigDecimal number2) {
        return addService(number1, number2);
    }

    private BigDecimal substractService(BigDecimal number1, BigDecimal number2) {
        BigDecimal result =  number1.subtract(number2);
        traceAPI.tracerAPI().trace(result);
        return result;
    }

    public BigDecimal substract(BigDecimal number1, BigDecimal number2) {
        return substractService(number1, number2);
    }


}

