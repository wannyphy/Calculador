package com.example.calculador.handlerexception;

import com.example.calculador.custom.ErrorResponseCustom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    private static final Logger logger = LogManager.getLogger(ExceptionHandlingAdvice.class);
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponseCustom> handleException(Exception e) {
            logger.error("Error en el servidor", e);
            ErrorResponseCustom errorResponse = new ErrorResponseCustom(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error en el sevidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
}

