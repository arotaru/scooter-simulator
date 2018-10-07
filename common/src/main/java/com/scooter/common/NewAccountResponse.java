package com.scooter.common;

public class NewAccountResponse {

	private boolean newAccountCreated;
	private Account account;
	private String newAccountUrl;

	public boolean isNewAccountCreated() {
		return newAccountCreated;
	}

	public void setNewAccountCreated(boolean created) {
		newAccountCreated = created;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account acct) {
		this.account = acct;
	}

	public String getNewAccountUrl() {
		return newAccountUrl;
	}

	public void setNewAccountUrl(String newUrl) {
		newAccountUrl = newUrl;
	}

	public String toString() {
		return "New Account Created: " + newAccountCreated + "\nNew Account Url: " + newAccountUrl + "\n"
				+ account != null ? account.toString() : null;
	}

}
