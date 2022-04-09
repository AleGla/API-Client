package com.AleGla.APIClient.responses;

import org.json.JSONObject;
import com.AleGla.APIClient.models.ResponseByID;
import com.AleGla.APIClient.utils.TransformToJson;

public class OKResponseByID {

	public static String responseOK(JSONObject json, ResponseByID okResp) {
			json.put("function", okResp.getFunction());
			json.put("status", okResp.getStatus());
			json.put("message", okResp.getMessage());
			json.put("Person", TransformToJson.toJsonPerson(okResp.getPerson()));
			return json.toString();
	}

}
