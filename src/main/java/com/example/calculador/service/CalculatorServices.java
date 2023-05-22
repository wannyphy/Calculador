package com.example.calculador.service;

import com.example.calculador.config.AppConfig;
import com.example.calculador.custom.CustomException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServices {

    private AppConfig traceAPI = new AppConfig();

    private BigDecimal addService(BigDecimal number1, BigDecimal number2) throws CustomException {
        try {
            BigDecimal result = number1.add(number2);
            traceAPI.tracerAPI().trace(result);
            return result;
        } catch (Exception e) {
            throw new CustomException("Error al realizar la suma de los números", e);
        }
    }

    public BigDecimal addNumber(BigDecimal number1, BigDecimal number2) throws CustomException {
        return addService(number1, number2);
    }

    private BigDecimal substractService(BigDecimal number1, BigDecimal number2) throws CustomException {
        try {
            BigDecimal result = number1.subtract(number2);
            traceAPI.tracerAPI().trace(result);
            return result;
        } catch (Exception e) {
            throw new CustomException("Error al realizar la resta de los números", e);
        }
    }
    public BigDecimal substractNumber(BigDecimal number1, BigDecimal number2)  throws CustomException {
        return substractService(number1, number2);
    }
}

