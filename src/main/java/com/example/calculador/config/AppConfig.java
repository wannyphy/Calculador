package com.example.calculador.config;

import io.corp.calculator.TracerAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TracerAPI tracerAPI() {
        return new TracerAPI() {
            @Override
            public <T> void trace(T result) {

            }
        };
    }
}
