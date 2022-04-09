package com.AleGla.APIClient.utils;

import java.util.Optional;
import org.json.JSONObject;
import com.AleGla.APIClient.models.Person2;

public class TransformToJson {

	public static JSONObject toJsonPerson(Optional<Person2> person) {
		JSONObject json = new JSONObject();
		if(person.get().getGender() == 70) json.put("gender", "F");
		else json.put("gender", "M");		
		json.put("nationality", person.get().getNationality());
		json.put("dni", person.get().getDNI());
		json.put("age", person.get().getAge());
		json.put("lastName", person.get().getLastName());
		json.put("name", person.get().getName());
		json.put("id", person.get().getId());
		
		return json;
	}


}
