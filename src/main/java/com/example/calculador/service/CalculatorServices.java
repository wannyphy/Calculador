package com.example.calculador.service;

import com.example.calculador.config.AppConfig;
import com.example.calculador.handlerexception.ExceptionHandlingAdvice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServices {

    private AppConfig traceAPI = new AppConfig();

    private static final Logger logger = LogManager.getLogger(ExceptionHandlingAdvice.class);


    private BigDecimal addService(BigDecimal number1, BigDecimal number2) throws Exception {
        try {
            BigDecimal result = number1.add(number2);
            traceAPI.tracerAPI().trace(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new Exception("Error al realizar la suma de los números", e);
        }
    }

    public BigDecimal addNumber(BigDecimal number1, BigDecimal number2) throws Exception {
        return addService(number1, number2);
    }

    private BigDecimal substractService(BigDecimal number1, BigDecimal number2) throws  Exception {
        try {
            BigDecimal result = number1.subtract(number2);
            traceAPI.tracerAPI().trace(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new Exception("Error al realizar la resta de los números", e);
        }
    }
    public BigDecimal substractNumber(BigDecimal number1, BigDecimal number2)  throws Exception  {
        return substractService(number1, number2);
    }
}

