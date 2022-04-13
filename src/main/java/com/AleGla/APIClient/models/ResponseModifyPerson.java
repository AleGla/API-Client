package com.AleGla.APIClient.models;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModifyPerson {
	
	
	@JsonProperty("person")
	private Optional<Person> person;

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private Integer status;

	@JsonProperty("function")
	private String function;
	
	@JsonProperty("ErrorCode")
	private String errorCode;

	@JsonProperty("ErrorMessage")
	private String errorMessage;
	
		
	public Optional<Person> getPerson() {
		return person;
	}

	public void setPerson(Optional<Person> person) {
		this.person = person;
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

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "person=" + person + ", message=" + message + ", status=" + status + ", function="
				+ function + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}


	
	
	
}
