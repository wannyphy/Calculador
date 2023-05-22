package com.example.calculador.controller;

import com.example.calculador.service.CalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorServices calculatorServices;

    @GetMapping("/add")
    private ResponseEntity<BigDecimal> addController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2) {
        try {
            BigDecimal result = calculatorServices.addNumber(number1, number2);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/subtract")
    private ResponseEntity<BigDecimal> subtractController(@RequestParam BigDecimal number1, @RequestParam BigDecimal number2) {
        try {
            BigDecimal result = calculatorServices.substractNumber(number1, number2);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}