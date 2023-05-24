package com.example.calculador.service;

import com.example.calculador.config.AppConfig;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class CalculatorServicesTests {
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
    void testAddNumber() throws Exception {
        // Arrange
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        BigDecimal expectedResult = BigDecimal.valueOf(15.9);
        MathOperation operation= new AdditionOperation();
        doNothing().when(tracerAPI).trace(expectedResult);

        // Act
        BigDecimal result = calculatorServices.performOperation(number1, number2,operation);

        // Assert
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(expectedResult);
    }

    @Test
    void testSubtractNumber() throws Exception {
        // Arrange
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        BigDecimal expectedResult = BigDecimal.valueOf(4.1);
        MathOperation operation= new SubtractionOperation();
        doNothing().when(tracerAPI).trace(expectedResult);

        // Act
        BigDecimal result = calculatorServices.performOperation(number1, number2,operation);

        // Assert
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(expectedResult);
    }

    @Test
    void testSubtractNumberWithCustomException(){

        BigDecimal number1 = null;
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        MathOperation operation= new AdditionOperation();


        Exception exception = assertThrows(Exception.class, () -> calculatorServices.performOperation(number1, number2,operation));
        assertEquals("Error al realizar la operación matemática", exception.getMessage());
        verifyNoInteractions(tracerAPI);
    }

    @Test
    void testAddNumberWithCustomException(){

        BigDecimal number1 = null;
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        MathOperation operation= new SubtractionOperation();

        Exception exception = assertThrows(Exception.class, () -> calculatorServices.performOperation(number1, number2,operation));
        assertEquals("Error al realizar la operación matemática", exception.getMessage());
        verifyNoInteractions(tracerAPI);
    }

}
