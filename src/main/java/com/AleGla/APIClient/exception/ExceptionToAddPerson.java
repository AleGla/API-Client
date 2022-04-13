package com.AleGla.APIClient.exception;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import com.AleGla.APIClient.models.Person;
import com.AleGla.APIClient.models.PersonAdd;


public class ExceptionToAddPerson {

	static Logger logger = LoggerFactory.getLogger(ExceptionToAddPerson.class);
	
	public static String errorAddPerson(JSONObject json, PersonAdd person) {
		if (person.getName() == null) {
			json.put("ErrorCode", "PE-400");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate the name of the person");
			logger.info(json.toString());
			return json.toString();
		}
		if (person.getLastName() == null) {
			json.put("ErrorCode", "PE-401");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate the lastName of the person");
			logger.info(json.toString());
			return json.toString();
		}
		if (person.getNationality() == null) {
			json.put("ErrorCode", "PE-402");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate the nationality of the person");
			logger.info(json.toString());
			return json.toString();
		}
		if (person.getDNI() == null) {
			json.put("ErrorCode", "PE-403");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate some DNI of the person");
			logger.info(json.toString());
			return json.toString();
		}
		if (person.getGender() == '\0' || person.getGender() == ' ') {
			json.put("ErrorCode", "PE-404");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate the gender of the person");
			logger.info(json.toString());
			return json.toString();
		}
		if (person.getAge() == null || person.getAge() == 0) {
			json.put("ErrorCode", "PE-405");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate the age of the person");
			logger.info(json.toString());
			return json.toString();
		}
		return "ok";

	}
	
	public static String errorModifyPerson(JSONObject json, Person person) {
		if(person.getId() == null || person.getId() <= 0) {
			json.put("ErrorCode", "PE-500");
			json.put("status", HttpStatus.BAD_REQUEST.value());
			json.put("ErrorMessage", "Must proporcionate the ID of the person");
			logger.info(json.toString());
			return json.toString();
		}		
		return "ok";

	}
	

}
