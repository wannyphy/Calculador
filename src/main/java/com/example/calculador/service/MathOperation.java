package com.example.calculador.service;

import java.math.BigDecimal;

public interface MathOperation {
    BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}