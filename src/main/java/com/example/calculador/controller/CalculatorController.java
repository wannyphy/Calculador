package com.example.calculador.controller;

import com.example.calculador.handlerexception.ExceptionHandlingAdvice;
import com.example.calculador.service.CalculatorServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorServices calculatorServices;
    private static final Logger logger = LogManager.getLogger(ExceptionHandlingAdvice.class);


    @GetMapping("/add")
    private ResponseEntity<String> addController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2){
        try {
            BigDecimal result = calculatorServices.addNumber(number1, number2);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller: Error al realizar la suma de los números");
        }
    }

    @GetMapping("/subtract")
    private ResponseEntity<String> subtractController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2){
        try {
            BigDecimal result = calculatorServices.substractNumber(number1, number2);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Controller: Error al resta la suma de los números");
        }
    }
}