package com.charger.network.service;

import org.springframework.stereotype.Service;

import com.charger.network.common.NewAccountRequest;
import com.charger.network.common.NewAccountResponse;

@Service
public class NewAccountService {

	public NewAccountResponse requestNewAccount(NewAccountRequest formData) {
		// 1. make the call to the downstream service to see if you can create a new account
		// 	a) if so, then create it
		//  b) if not, then put the person in line for a new account
		
		// TODO: implement step 1. -> a) or b)
		NewAccountResponse response = new NewAccountResponse();
		
		response.setNewAccountCreated(true);
		//response.setAccount(new Account());
		
		return response;
	}
	
}
