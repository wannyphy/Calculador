package com.example.calculador.custom;

public class ErrorResponseCustom {
    private int statusCode;
    private String message;

    public ErrorResponseCustom(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

}

