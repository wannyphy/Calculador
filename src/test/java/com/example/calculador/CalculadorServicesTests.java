package com.example.calculador;

import com.example.calculador.config.AppConfig;
import com.example.calculador.service.CalculatorServices;
import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
        int number1 = 10;
        int number2 = 5;
        int expectedResult = 15;

        doNothing().when(tracerAPI).trace(anyInt());
        int result = calculatorServices.add(number1, number2);
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(result);
    }
    @Test
    void testSubstract() {
        int number1 = 10;
        int number2 = 5;
        int expectedResult = 5;

        doNothing().when(tracerAPI).trace(anyInt());
        int result = calculatorServices.substract(number1, number2);
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(result);
    }
}

