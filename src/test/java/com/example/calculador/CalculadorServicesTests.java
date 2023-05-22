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
        doNothing().when(tracerAPI).trace(expectedResult);

        // Act
        BigDecimal result = calculatorServices.addNumber(number1, number2);

        // Assert
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(expectedResult);
    }

    @Test
    void testAddNumberWithException() throws Exception {
        // Arrange
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = null;
        doNothing().when(tracerAPI).trace(any(BigDecimal.class));

        // Act and Assert
        try {
            calculatorServices.addNumber(number1, number2);
        } catch (Exception e) {
            assertEquals("Error: ", e.getMessage());
        }
        verifyNoInteractions(tracerAPI);
    }

    @Test
    void testSubtractNumber() throws Exception {
        // Arrange
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        BigDecimal expectedResult = BigDecimal.valueOf(4.1);
        doNothing().when(tracerAPI).trace(expectedResult);

        // Act
        BigDecimal result = calculatorServices.substractNumber(number1, number2);

        // Assert
        assertEquals(expectedResult, result);
        verify(tracerAPI).trace(expectedResult);
    }

    @Test
    void testSubtractNumberWithException() throws Exception {
        // Arrange
        BigDecimal number1 = null;
        BigDecimal number2 = BigDecimal.valueOf(5.9);
        doNothing().when(tracerAPI).trace(any(BigDecimal.class));

        // Act and Assert
        try {
            calculatorServices.substractNumber(number1, number2);
        } catch (Exception e) {
            assertEquals("Error:", e.getMessage());
        }
        verifyNoInteractions(tracerAPI);
    }
}