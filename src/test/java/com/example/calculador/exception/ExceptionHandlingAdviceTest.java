package com.example.calculador.exception;

import com.example.calculador.custom.ErrorResponseCustom;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionHandlingAdviceTest {

    @Test
    void handleException_ShouldReturnInternalServerError() {

        ExceptionHandlingAdvice advice = new ExceptionHandlingAdvice();
        ErrorResponseCustom errorResponseCustom = new ErrorResponseCustom(400,"Test custom exception");
        Exception exception = new Exception("Test custom exception");

        ResponseEntity<ErrorResponseCustom> response = advice.handleException(exception);

        assertEquals(HttpStatus.
                BAD_REQUEST, response.getStatusCode());
        assertEquals("Test custom exception", errorResponseCustom.getMessage());
    }
}
