package com.scooter.common;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChargerApplicant {

	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private int age;
	private String ssn;
	private boolean createdSuccessfully = false;

	public ChargerApplicant() {
	}

	public ChargerApplicant(JSONObject jsonObj) {
		JSONArray dataJsonArray = jsonObj.getJSONArray("results");

		JSONObject dataObj;

		if (dataJsonArray != null && dataJsonArray.length() > 0) {
			dataObj = dataJsonArray.getJSONObject(0);

			JSONObject name = dataObj.getJSONObject("name");
			JSONObject location = dataObj.getJSONObject("location");
			JSONObject dob = dataObj.getJSONObject("dob");
			JSONObject id = dataObj.getJSONObject("id");

			setFirstName(name.getString("first"));
			setLastName(name.getString("last"));

			createAddress(location.getString("street"), location.getString("city"), location.getString("state"),
					location.getNumber("postcode").intValue());

			setEmail(dataObj.getString("email"));

			setAge(dob.getNumber("age").intValue());

			setSsn(id.getString("value"));

			createdSuccessfully = true;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void createAddress(String street, String city, String state, int zip) {
		this.address = street + " " + city + " " + state + " " + zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public boolean isCreatedSuccessfully() {
		return createdSuccessfully;
	}

}
