package com.example.calculador.service;


import com.example.calculador.config.AppConfig;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServices {

    private AppConfig traceAPI=new AppConfig();

    private Integer addService(int number1, int number2) {
        int result = number1 + number2;
        traceAPI.tracerAPI().trace(result);
        return result;
    }

    public Integer add(int number1, int number2) {
        return addService(number1, number2);
    }

    private Integer substractService(int number1, int number2) {
        int result = number1 - number2;
        traceAPI.tracerAPI().trace(result);
        return result;
    }

    public Integer substract(int number1, int number2) {
        return substractService(number1, number2);
    }


}

