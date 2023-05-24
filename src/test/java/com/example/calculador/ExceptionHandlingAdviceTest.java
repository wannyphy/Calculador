package com.example.calculador;

import com.example.calculador.custom.ErrorResponseCustom;
import com.example.calculador.handlerexception.ExceptionHandlingAdvice;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionHandlingAdviceTest {

    @Test
    void handleException_ShouldReturnInternalServerError() {

        ExceptionHandlingAdvice advice = new ExceptionHandlingAdvice();
        ErrorResponseCustom errorResponseCustom = new ErrorResponseCustom(500,"Test custom exception");
        Exception exception = new Exception("Test custom exception");

        ResponseEntity<ErrorResponseCustom> response = advice.handleException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Test custom exception", errorResponseCustom.getMessage());
    }
}
