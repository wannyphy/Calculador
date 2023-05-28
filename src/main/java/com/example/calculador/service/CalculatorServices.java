package com.example.calculador.service;

import com.example.calculador.config.AppConfig;
import com.example.calculador.exception.ExceptionHandlingAdvice;
import com.example.calculador.service.operation.MathOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServices {

    private AppConfig traceAPI = new AppConfig();

    private static final Logger logger = LogManager.getLogger(ExceptionHandlingAdvice.class);

    public BigDecimal performOperation(BigDecimal number1, BigDecimal number2, MathOperation operation) throws Exception {
        try {
            BigDecimal result = operation.calculate(number1, number2);
            traceAPI.tracerAPI().trace(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new Exception("Error al realizar la operación matemática", e);
        }
    }
}