package com.AleGla.APIClient.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.AleGla.APIClient.exception.ExceptionToAddPerson;
import com.AleGla.APIClient.models.Person;
import com.AleGla.APIClient.models.PersonAdd;
import com.AleGla.APIClient.models.PersonRequest;
import com.AleGla.APIClient.models.Response;
import com.AleGla.APIClient.models.ResponseAddPerson;
import com.AleGla.APIClient.models.ResponseByID;
import com.AleGla.APIClient.models.ResponseModifyPerson;
import com.AleGla.APIClient.responses.OKResponseAddPerson;
import com.AleGla.APIClient.responses.OKResponseByID;
import com.AleGla.APIClient.utils.BadResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

@RestController
public class Controller {

	static Logger logger = LoggerFactory.getLogger(ExceptionToAddPerson.class);
	private HttpConsumeAPI consume = new HttpConsumeAPI(new RestTemplate());

	@GetMapping(value = "people", produces = { "application/json" })
	public String getAllPeople() throws JsonProcessingException {
		JSONObject json = new JSONObject();
		ResponseEntity<String> response = consume.HttpConsume();	
		
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new Jdk8Module());
		Response okResp = obj.readValue(response.getBody(), Response.class);		
		logger.info("Response Consume API = " + response);				
		
		if(response.getStatusCodeValue() == 200 && okResp.getStatus() == 200) return response.getBody();
		else return BadResponse.exceptionResponse(json, okResp);
	}

	@GetMapping(value = "person", produces = { "application/json" })
	public String getPerson(@RequestBody PersonRequest person) throws JsonMappingException, JsonProcessingException {
		JSONObject json = new JSONObject();
		ResponseEntity<String> response = consume.httpConsume(person.getId(), person.getFunction());
		
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new Jdk8Module());
		ResponseByID okResp = obj.readValue(response.getBody(), ResponseByID.class);		
		logger.info("Response Consume API = " + response);				
		
		if(response.getStatusCodeValue() == 200 && okResp.getStatus() == 200) return OKResponseByID.responseOK(json, okResp);
		else return BadResponse.exceptionResponse(json, okResp);			
		
	}
	
	@PostMapping(value = "add", produces = {"application/json"})
	public String addPerson(@RequestBody PersonAdd person) throws JsonMappingException, JsonProcessingException {
		JSONObject json = new JSONObject();		
		if(!(ExceptionToAddPerson.errorAddPerson(json, person).equalsIgnoreCase("ok"))) return ExceptionToAddPerson.errorAddPerson(json, person);
		
		ResponseEntity<String> response = consume.httpConsume(person);
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new Jdk8Module());
		ResponseAddPerson okResp = obj.readValue(response.getBody(), ResponseAddPerson.class);
		logger.info("Response Consume API = " + okResp);
		return OKResponseAddPerson.responseOK(json, person, okResp);			
	}
	
	@PutMapping(value = "modify", produces ={"application/json"})
	public String modifyPerson(@RequestBody Person person) throws JsonMappingException, JsonProcessingException {
		JSONObject json = new JSONObject();
		if(!(ExceptionToAddPerson.errorModifyPerson(json, person).equalsIgnoreCase("ok"))) return ExceptionToAddPerson.errorModifyPerson(json, person);
		
		ResponseEntity<String> response = consume.httpConsume(person);
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new Jdk8Module());
		ResponseModifyPerson okResp = obj.readValue(response.getBody(), ResponseModifyPerson.class);
		logger.info("Response Consume API = " + okResp);
		return OKResponseAddPerson.responseOK(json, person, okResp);	
	}
	
	@DeleteMapping(value= "delete", produces ={"application/json"})
	public String deletePerson(@RequestBody PersonRequest pRequest) throws JsonMappingException, JsonProcessingException {
		JSONObject json = new JSONObject();
		ResponseEntity<String> response = consume.httpConsume(pRequest.getId(), pRequest.getFunction());
		
		ObjectMapper obj = new ObjectMapper();
		obj.registerModule(new Jdk8Module());
		ResponseByID okResp = obj.readValue(response.getBody(), ResponseByID.class);
		logger.info("Response Consume API = " + response);
		
		if(response.getStatusCodeValue() == 200 && okResp.getStatus() == 200) return OKResponseByID.responseOK(json, okResp);
		else return BadResponse.exceptionResponse(json, okResp);			
		
	}

}
