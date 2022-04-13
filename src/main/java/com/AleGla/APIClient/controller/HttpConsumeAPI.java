package com.AleGla.APIClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.AleGla.APIClient.models.Person;
import com.AleGla.APIClient.models.PersonAdd;
import com.AleGla.APIClient.utils.TransformToJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class HttpConsumeAPI {

	private final RestTemplate restTemplate;
	private String URL;
	private String authUser = "QWxlR2xhfFVzZXI9UGVyc29uOkFsZUdsYXxQYXNzPUFMTC4tVGhhbmtzIGZvciB0ZXN0IG15IGFwcGxpY2F0aW9uISE9RA";
	private String authAdmin = "QWxlR2xhfFVzZXI9UGVyc29uOkFsZUdsYXxQYXNzPUFETUlOLi1UaGFua3MgZm9yIHRlc3QgbXkgYXBwbGljYXRpb24hIT1E";
	
	
	@Autowired
	public HttpConsumeAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<String> HttpConsume() {
		URL = "http://localhost:8080/person/all";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + authUser);	
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
	}

	public ResponseEntity<String> httpConsume(Integer person, String function) throws JsonMappingException, JsonProcessingException {
		if(function.equalsIgnoreCase("delete")) {
			URL = "http://localhost:8080/person/delete/" + person;	
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + authAdmin);	
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			return restTemplate.exchange(URL, HttpMethod.DELETE, entity , String.class);			
		}
		else {
			URL = "http://localhost:8080/person/search/" + person;
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + authUser);	
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			return restTemplate.exchange(URL, HttpMethod.GET, entity,String.class); 
		}		
	}
	
	public ResponseEntity<String> httpConsume(PersonAdd person) {		
		 URL = "http://localhost:8080/person/new";
		String json = TransformToJson.toJsonPerson(person).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + authAdmin);
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> entity = new HttpEntity<String>(json,headers);
		return restTemplate.postForEntity(URL, entity, String.class);
	}
	
	public ResponseEntity<String> httpConsume(Person person){
		URL = "http://localhost:8080/person/modify";
		String json = TransformToJson.toJsonPerson(person).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + authAdmin);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(json,headers);
		return restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class);
	}
	
	
}
	
	


