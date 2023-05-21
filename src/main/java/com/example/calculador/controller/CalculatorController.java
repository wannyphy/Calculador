package com.example.calculador.controller;

import com.example.calculador.service.CalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @Autowired
CalculatorServices calculatorServices;
    @GetMapping("/add")
    private ResponseEntity<Integer> addController(@RequestParam int number1, @RequestParam int number2) {
        int result = calculatorServices.add(number1, number2);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/subtract")
    private ResponseEntity<Integer> subtractControlle(@RequestParam int number1, @RequestParam int number2) {
        int result = calculatorServices.substract(number1, number2);
        return ResponseEntity.ok(result);
    }
}