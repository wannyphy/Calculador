package com.example.calculador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int number1, @RequestParam int number2) {
        int result = number1 + number2;
        return ResponseEntity.ok(result);
    }

    @GetMapping("/subtract")
    public ResponseEntity<Integer> subtract(@RequestParam int number1, @RequestParam int number2) {
        int result = number1 - number2;
        return ResponseEntity.ok(result);
    }
}