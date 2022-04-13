package com.AleGla.APIClient.responses;

import org.json.JSONObject;
import com.AleGla.APIClient.models.Person;
import com.AleGla.APIClient.models.PersonAdd;
import com.AleGla.APIClient.models.ResponseAddPerson;
import com.AleGla.APIClient.models.ResponseModifyPerson;
import com.AleGla.APIClient.utils.TransformToJson;

public class OKResponseAddPerson {

	
	
	public static String responseOK(JSONObject json, PersonAdd person, ResponseAddPerson okResp) {
		json.put("function", okResp.getFunction());
		json.put("status", okResp.getStatus());
		json.put("message", okResp.getMessage());
		json.put("person", TransformToJson.toJsonPerson(person));
		return json.toString();		
	}
	
	public static String responseOK(JSONObject json, Person person, ResponseModifyPerson okResp) {
		json.put("function", okResp.getFunction());
		json.put("status", okResp.getStatus());
		json.put("message", okResp.getMessage());
		json.put("person", TransformToJson.toJsonPerson(person));
		return json.toString();		
	}
	
	
	
	
	
}