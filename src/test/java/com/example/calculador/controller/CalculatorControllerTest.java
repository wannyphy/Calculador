package com.example.calculador.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void addController_ShouldReturnCorrectResult() throws Exception {
        BigDecimal number1 = BigDecimal.valueOf(5);
        BigDecimal number2 = BigDecimal.valueOf(3);
        BigDecimal expectedResult = BigDecimal.valueOf(8);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculator/add")
                .param("number1", number1.toString())
                .param("number2", number2.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResult.toString()));
    }

    @Test
    void subtractController_ShouldReturnCorrectResult() throws Exception {
        BigDecimal number1 = BigDecimal.valueOf(10);
        BigDecimal number2 = BigDecimal.valueOf(4);
        BigDecimal expectedResult = BigDecimal.valueOf(6);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculator/subtract")
                .param("number1", number1.toString())
                .param("number2", number2.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResult.toString()));
    }
}