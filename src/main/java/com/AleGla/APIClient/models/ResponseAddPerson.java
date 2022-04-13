package com.AleGla.APIClient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAddPerson {

	@JsonProperty("person")
	private Person person;
	
	@JsonProperty("function")
	private String function;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("status")
	private String status;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "person=" + person + ", function=" + function + ", message=" + message + ", status="
				+ status ;
	}
	
	
	
}
