package com.AleGla.APIClient.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomException{

	static Logger logger = LoggerFactory.getLogger(CustomException.class);
	
	@JsonProperty("ErrorMessage")
	private String errorMessage;
	
	@JsonProperty("ErrorCode")
	private String errorCode;
	
	@JsonProperty("Status")
	private Integer status;
	
	private ApiException exception;

	public ApiException notFoundExceptionPerson() {
			errorMessage = "The Person doesn't exists in the database".toString();
			errorCode = "PEDB-0001".toString();			
			exception = new ApiException(errorMessage, errorCode);
			logger.info(exception.toString());
			return exception;
	}
	
	public ApiException isNullSomeAttributePerson() {
		errorMessage = "Are necessary all data of the person for be add to the person".toString();
		errorCode = "PERQ-0001".toString();			
		exception = new ApiException(errorMessage, errorCode);
		logger.info(exception.toString());
		return exception;
	
	}
	
	public ApiException isNullSomeAttributeGame() {
		errorMessage = "Are necessary all data of the game for be add to the game".toString();
		errorCode = "GARQ-0001".toString();			
		exception = new ApiException(errorMessage, errorCode);
		logger.info(exception.toString());
		return exception;
	
	}
	
	public ApiException notFoundExceptionGame() {
		errorMessage = "The game doesn't exists in the database".toString();
		errorCode = "GADB-0001".toString();			
		exception = new ApiException(errorMessage, errorCode);
		logger.info(exception.toString());
		return exception;
	}
	
	public ApiException EmptyDataBasePerson() {
		errorMessage = "Couldn't get information from database".toString();
		errorCode = "PEDB-9999".toString();			
		exception = new ApiException(errorMessage, errorCode);
		logger.info(exception.toString());
		return exception;
	}
	
	public ApiException EmptyDataBaseGame() {
		errorMessage = "Couldn't get information from database".toString();
		errorCode = "GADB-9999".toString();			
		exception = new ApiException(errorMessage, errorCode);
		logger.info(exception.toString());
		return exception;
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	public ApiException getException() {
		return exception;
	}


	public void setException(ApiException exception) {
		this.exception = exception;
	}


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
		
}
