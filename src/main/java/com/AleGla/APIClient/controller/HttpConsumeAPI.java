package com.AleGla.APIClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.AleGla.APIClient.models.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class HttpConsumeAPI {

	private final RestTemplate restTemplate;

	@Autowired
	public HttpConsumeAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Response HttpConsume() {
		String URL = "http://localhost:8080/person/all";
		return restTemplate.getForObject(URL, Response.class);
	}

	public ResponseEntity<String> HttpConsume(Integer person) throws JsonMappingException, JsonProcessingException {
		String URL = "http://localhost:8080/person/search/" + person;
		 ResponseEntity<String> resp = restTemplate.getForEntity(URL, String.class);
		return resp;		
	}
}
	
	


