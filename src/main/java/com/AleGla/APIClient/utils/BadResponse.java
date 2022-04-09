package com.AleGla.APIClient.utils;

import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;

import com.AleGla.APIClient.models.Response;
import com.AleGla.APIClient.models.ResponseByID;
import com.fasterxml.jackson.core.JsonProcessingException;


public class BadResponse {

	public static String exceptionResponse(JSONObject json, ResponseByID response) throws JsonProcessingException {
		json.put("ErrorCode", response.getErrorCode());
		json.put("status", response.getStatus());
		json.put("ErrorMessage", response.getErrorMessage());		
		LogManager.getLogger().info(json);
		return json.toString();
	}
	
	public static String exceptionResponse(JSONObject json, Response response) throws JsonProcessingException {
		json.put("ErrorCode", response);		
		LogManager.getLogger().info(json);
		return json.toString();
	}
}
