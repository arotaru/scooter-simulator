package com.charger.account.common;

public class NewAccountResponse {

	private boolean newAccountCreated;
	private AccountResponse account;
	private String newAccountUrl;

	public boolean isNewAccountCreated() {
		return newAccountCreated;
	}

	public void setNewAccountCreated(boolean created) {
		newAccountCreated = created;
	}

	public AccountResponse getAccount() {
		return account;
	}

	public void setAccountForResponse(Account acct) {
		this.account = transformAccountForResponse(acct);
	}
	
	private AccountResponse transformAccountForResponse(Account acct) {
		return new AccountResponse(acct);
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
