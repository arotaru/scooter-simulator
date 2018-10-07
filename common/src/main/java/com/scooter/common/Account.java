package com.scooter.common;

public class Account {

	private long id;
	private String dateCreated;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String email;
	private String ssn;
	private String requestedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Id: " + id + "\nDate Created: " + dateCreated + "\nName: " + firstName + " " + lastName + "\nAge: "
				+ age + "\nAddress: " + address + "\nEmail: " + email + "\nSSN: " + ssn + "\nAccount Requested Date: "
				+ requestedDate;
	}

}
