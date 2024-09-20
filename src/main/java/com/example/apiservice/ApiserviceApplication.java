package com.example.apiservice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.apiservice.transcript.Transcript;
import com.google.gson.Gson;

@SpringBootApplication
public class ApiserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiserviceApplication.class, args);
		
		Transcript transcript = new Transcript();
		transcript.setAudio_url("https://github.com/TheBuckeyeMan/Youtube_Learning/blob/Speech_To_Text_Java_Rest_API/audio_files/Thirsty.mp4");
		Gson gson = new Gson();
		String jsonRequest = gson.toJson(transcript);

		System.out.println(jsonRequest);
		HttpRequest postRequest = HttpRequest.newBuilder()
		.uri(new URI("https://api.assemblyai.com/v2/transcript"))
		.header("Authorization", "f1509c083db1409eb14d6223c497e470")
		.POST(BodyPublishers.ofString(jsonRequest))
		.build();

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());

		System.out.println(postResponse.body());



	}

}
