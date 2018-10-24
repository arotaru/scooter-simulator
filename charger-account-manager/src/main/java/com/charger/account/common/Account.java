package com.charger.account.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {

	@Id
	private ObjectId _id;
	
	private String dateCreated;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String email;
	private String ssn;
	private String requestedDate;
	
	public Account() {}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public String getIdString() {
		return _id.toString();
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer();
		
		buff.append(get_id());
		buff.append(":" + getDateCreated());
		buff.append(":" + getAddress());
		buff.append(":" + getAge());
		buff.append(":" + getEmail());
		buff.append(":" + getFirstName());
		buff.append(":" + getLastName());
		buff.append(":" + getRequestedDate());
		buff.append(":" + getSsn());
		
		return buff.toString();
	}
	
}
