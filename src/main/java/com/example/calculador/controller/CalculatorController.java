package com.example.calculador.controller;

import com.example.calculador.exception.ExceptionHandlingAdvice;
import com.example.calculador.service.AdditionOperation;
import com.example.calculador.service.CalculatorServices;
import com.example.calculador.service.MathOperation;
import com.example.calculador.service.SubtractionOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorServices calculatorServices;
    private static final Logger logger = LogManager.getLogger(ExceptionHandlingAdvice.class);

    @Operation(summary = "Operación de Suma", description = "Realiza la suma de dos números")
    @GetMapping("/add")
    private ResponseEntity<String> addController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2){
        MathOperation addition = new AdditionOperation();
        try {
            BigDecimal result = calculatorServices.performOperation(number1, number2, addition);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller: Error al realizar la suma de los números");
        }
    }

    @Operation(summary = "Operación de Resta", description = "Realiza la resta de dos números")
    @GetMapping("/subtract")
    private ResponseEntity<String> subtractController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2){
        MathOperation subtract = new SubtractionOperation();
        try {
            BigDecimal result = calculatorServices.performOperation(number1, number2, subtract);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller: Error al resta la suma de los números");
        }
    }
}