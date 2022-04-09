package com.AleGla.APIClient.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.AleGla.APIClient.models.Person;
import com.AleGla.APIClient.models.Response;
import com.AleGla.APIClient.models.ResponseByID;
import com.AleGla.APIClient.responses.OKResponseAllPerson;
import com.AleGla.APIClient.responses.OKResponseByID;
import com.AleGla.APIClient.utils.BadResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

@RestController
public class Controller {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	private HttpConsumeAPI consume = new HttpConsumeAPI(new RestTemplate());

	@GetMapping(value = "people", produces = { "application/json" })
	public String getAllPeople() throws JsonProcessingException {
		JSONObject json = new JSONObject();
		Response response = consume.HttpConsume();
		
		log.info("Response Consume API = " + response);
		
		if(response.getStatus() == 200) return OKResponseAllPerson.responseOK(json, response);
		else return BadResponse.exceptionResponse(json, response);

	}

	@GetMapping(value = "person", produces = { "application/json" })
	public String getPerson(@RequestBody Person person) throws JsonMappingException, JsonProcessingException {
		JSONObject json = new JSONObject();
		ResponseEntity<String> response = consume.HttpConsume(person.getId());
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new Jdk8Module());
		ResponseByID okResp = obj.readValue(response.getBody(), ResponseByID.class);		
		log.info("Response Consume API = " + response);				
		
		if(response.getStatusCodeValue() == 200 && okResp.getStatus() == 200) return OKResponseByID.responseOK(json, okResp);
		else return BadResponse.exceptionResponse(json, okResp);			
		
	}

}
