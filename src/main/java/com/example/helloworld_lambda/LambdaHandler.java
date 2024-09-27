package com.example.helloworld_lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<Object, String> {
    @Override
    public String handleRequest(Object input, Context context) {
        return "Hello, World!";
    }
}