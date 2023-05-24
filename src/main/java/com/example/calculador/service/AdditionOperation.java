package com.example.calculador.service;

import java.math.BigDecimal;

public class AdditionOperation implements MathOperation {
    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.add(number2);
    }
}