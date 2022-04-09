package com.AleGla.APIClient.exception;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ApiException extends Exception{

	private static final long serialVersionUID = -5396895474982926193L;
	
	@JsonProperty("ErrorCode")
	private String code;
	
	@JsonProperty("ErrorMessage")
	private String errorMessage;
	
	public ApiException(String errorMessage, String code) {
		super(errorMessage);
		this.code = code;
		this.errorMessage = errorMessage;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ApiException [code=" + code + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
	
	

