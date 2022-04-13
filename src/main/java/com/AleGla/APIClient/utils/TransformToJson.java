package com.AleGla.APIClient.utils;

import java.util.Optional;
import org.json.JSONObject;
import com.AleGla.APIClient.models.Person;
import com.AleGla.APIClient.models.PersonAdd;

public class TransformToJson {

	public static JSONObject toJsonPerson(Optional<Person> person) {
		JSONObject json = new JSONObject();
		if(person.get().getGender() == 70) json.put("gender", "F");
		else json.put("gender", "M");		
		json.put("nationality", person.get().getNationality());
		json.put("DNI", person.get().getDNI());
		json.put("age", person.get().getAge());
		json.put("lastName", person.get().getLastName());
		json.put("name", person.get().getName());
		json.put("id", person.get().getId());
		
		return json;
	}
	
	public static JSONObject toJsonPerson(Person person) {
		JSONObject json = new JSONObject();
		if(person.getGender() == 70) json.put("gender", "F");
		else json.put("gender", "M");		
		json.put("nationality", person.getNationality());
		json.put("DNI", person.getDNI());
		json.put("age", person.getAge());
		json.put("lastName", person.getLastName());
		json.put("name", person.getName());
		json.put("id", person.getId());
		
		return json;
	}
	

	public static JSONObject toJsonPerson(PersonAdd person) {
		JSONObject json = new JSONObject();
		if(person.getGender() == 70) json.put("gender", "F");
		else json.put("gender", "M");		
		json.put("nationality", person.getNationality());
		json.put("DNI", person.getDNI());
		json.put("age", person.getAge());
		json.put("lastName", person.getLastName());
		json.put("name", person.getName());
		
		return json;
	}

}
