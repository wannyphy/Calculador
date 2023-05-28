package com.example.calculador.service.operation;

import com.example.calculador.service.operation.MathOperation;

import java.math.BigDecimal;

public class SubtractionOperation implements MathOperation {
    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.subtract(number2);
    }
}