package com.example.apiservice.service;

import java.util.List;
import java.util.Arrays;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.apiservice.api.model.Model;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

//This service is to do something

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    //Make getter method for our model
    public List<Model> getModel(){
        String url = "https://api.api-ninjas.com/v1/facts";

        List<Model> model = null;
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);

            model = objectMapper.readValue(jsonResponse, new TypeReference<List<Model>>() {});

            log.info("Recieved JSON Response from external API: {}", jsonResponse);//Log the JSON Response from Extenral API
                if (model != null) {
                    log.info("Model Successful Build!");
                }
                } catch (HttpStatusCodeException e) {
                    log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);//log error if an error status code is returned
                } catch (Exception e) {
                    log.error("An Error Occured while making the reques tto external API: {}", e);
                }
       return model;
    }


}
