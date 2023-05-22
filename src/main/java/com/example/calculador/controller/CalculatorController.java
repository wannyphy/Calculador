package com.example.calculador.controller;

import com.example.calculador.custom.CustomException;
import com.example.calculador.service.CalculatorServices;
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

    @GetMapping("/add")
    private ResponseEntity<String> addController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2) throws Exception {
        try {
            BigDecimal result = calculatorServices.addNumber(number1, number2);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (CustomException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/subtract")
    private ResponseEntity<String> subtractController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2) throws Exception {
        try {
            BigDecimal result = calculatorServices.substractNumber(number1, number2);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (CustomException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}