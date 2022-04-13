package com.AleGla.APIClient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRequest {

	@JsonProperty("id")
	private Integer id;	
	
	@JsonProperty("function")
	private String function;
	
	public PersonRequest() {}
	

	public PersonRequest(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getFunction() {
		return function;
	}


	public void setFunction(String function) {
		this.function = function;
	}


	@Override
	public String toString() {
		return "id=" + id + ", function=" + function;
	}

			
}
