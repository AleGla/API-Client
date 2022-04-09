package com.AleGla.APIClient.responses;

import org.json.JSONObject;

import com.AleGla.APIClient.models.Response;

public class OKResponseAllPerson {

	public static String responseOK(JSONObject json, Response response) {
		json.put("function", response.getFunction());
		json.put("status", response.getStatus());
		json.put("message", response.getMessage());
		json.put("people", response.getPersons());
		return json.toString();
	}
}
