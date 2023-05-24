package com.example.calculador.service;

import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracerService {
    private final TracerImpl tracer;

    @Autowired
    public TracerService(TracerImpl tracer) {
        this.tracer = tracer;
    }
}