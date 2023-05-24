package com.example.calculador;

import com.example.calculador.custom.CustomException;
import com.example.calculador.handlerexception.ExceptionHandlingAdvice;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionHandlingAdviceTest {

    @Test
    void handleException_ShouldReturnInternalServerError() {
        ExceptionHandlingAdvice advice = new ExceptionHandlingAdvice();
        Exception exception = new Exception("Test exception");

        ResponseEntity<String> response = advice.handleException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error en el servidor", response.getBody());
    }

    @Test
    void handleCustomException_ShouldReturnBadRequestWithCustomMessage() {
        ExceptionHandlingAdvice advice = new ExceptionHandlingAdvice();
        CustomException customException = new CustomException("Test custom exception");

        ResponseEntity<String> response = advice.handleCustomException(customException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Test custom exception", response.getBody());
    }
}
