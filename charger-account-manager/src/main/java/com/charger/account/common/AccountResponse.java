package com.charger.account.common;

public class AccountResponse {

	private String id;
	private String dateCreated;
	
	public AccountResponse() {}
	
	public AccountResponse(Account acct) {
		setId(acct.getIdString());
		setDateCreated(acct.getDateCreated());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
