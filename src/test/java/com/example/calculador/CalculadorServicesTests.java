package com.example.calculador;

import com.example.calculador.config.AppConfig;
import com.example.calculador.service.CalculatorServices;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class CalculadorServicesTests {
    @Mock
    private TracerImpl tracerAPI;
    @Mock
    private AppConfig appConfig;
    @InjectMocks
    private CalculatorServices calculatorServices;

    @BeforeEach
    void setUp() {
        when(appConfig.tracerAPI()).thenReturn(tracerAPI);
    }

    @Test
    void testAdd() {
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        BigDecimal expectedResult = BigDecimal.valueOf(15.9);

        doNothing().when(tracerAPI).trace(anyInt());
        BigDecimal result = calculatorServices.add(number1, number2);
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(result);
    }
    @Test
    void testSubstract() {
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        BigDecimal expectedResult = BigDecimal.valueOf(4.1);

        doNothing().when(tracerAPI).trace(anyInt());
        BigDecimal result = calculatorServices.substract(number1, number2);
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(result);
    }
}

