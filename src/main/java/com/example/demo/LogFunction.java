package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LogFunction {

    @Bean
    public Function<String, String> logMessage() {
        return input -> {
            System.out.println("Logging from AWS Lambda: " + input);
            return "Logged: " + input;
        };
    }
}