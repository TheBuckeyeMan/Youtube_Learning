package com.example.apiservice.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.apiservice.api.interceptor.ApiKeyInterceptor;
import com.example.apiservice.api.interceptor.IncommingLoggingInterceptor;
import com.example.apiservice.api.interceptor.ToExternalLoggingInterceptor;

import java.util.Arrays;


//The entire purpose of the configuration file is to simply configure ther RestTemplate as a bean in the application s it can be autowired
@Configuration
public class AppConfig {

    @Value("${api.key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate(ToExternalLoggingInterceptor toExternalLoggingInterceptor,IncommingLoggingInterceptor incommingLoggingInterceptor,ApiKeyInterceptor apiKeyInterceptor){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList(apiKeyInterceptor,incommingLoggingInterceptor,toExternalLoggingInterceptor)); //If we have any other requests we want to intercept, we can capture them registering here
        return restTemplate;
    }

    @Bean
    public ApiKeyInterceptor apiKeyInterceptor(){
        return new ApiKeyInterceptor(apiKey);
    }
}
