package com.AleGla.APIClient.models;

import java.io.Serializable;
import java.util.List;


public class Response implements Serializable{


	private static final long serialVersionUID = -6327065270806377509L;

	private List<Person> persons;
	
	private String message;
	
	private Integer status;
	
	private String function;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}


	
	
	
}
