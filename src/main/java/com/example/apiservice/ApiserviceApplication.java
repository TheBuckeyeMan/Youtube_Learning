package com.example.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.apiservice.service.TemplateService;
import java.util.List;
import com.example.apiservice.api.model.Model;

@SpringBootApplication
public class ApiserviceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ApiserviceApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();

		TemplateService templateService = new TemplateService(restTemplate, objectMapper);

		List<Model> models = templateService.getModel();

	}

}
