package com.AleGla.APIClient.utils;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.AleGla.APIClient.models.Response;
import com.AleGla.APIClient.models.ResponseByID;
import com.fasterxml.jackson.core.JsonProcessingException;


public class BadResponse {

	static Logger logger = LoggerFactory.getLogger(BadResponse.class);
	
	public static String exceptionResponse(JSONObject json, ResponseByID response) throws JsonProcessingException {
		json.put("ErrorCode", response.getErrorCode());
		json.put("status", response.getStatus());
		json.put("ErrorMessage", response.getErrorMessage());		
		logger.info(json.toString());
		return json.toString();
	}
	
	public static String exceptionResponse(JSONObject json, Response response) throws JsonProcessingException {
		json.put("ErrorCode", response);		
		logger.info(json.toString());
		return json.toString();
	}
}
