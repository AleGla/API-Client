package com.AleGla.APIClient.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable{


	private static final long serialVersionUID = 2806315334489312722L;

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("age")
	private Integer age;
	
	@JsonProperty("DNI")
	private String DNI;
	
	@JsonProperty("nationality")
	private String Nationality;
	
	@JsonProperty("gender")
	private char gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", DNI=" + DNI
				+ ", Nationality=" + Nationality + ", gender=" + gender;
	}
	
	
	
}
