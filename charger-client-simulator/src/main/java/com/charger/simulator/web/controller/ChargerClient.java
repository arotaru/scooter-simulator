package com.charger.simulator.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.charger.simulator.common.NewAccountRequest;

/**
 * This is the client that will initiate requests to create new Charger objects/accounts.
 * Also this client will send requests to cancel Charger Accounts
 * @author erik rotaru
 *
 */
@RestController
public class ChargerClient {
	
	@Qualifier("chargerAccountsWebClient")
	@Autowired
	WebClient chargerAccountsWebClient;
	
	@Qualifier("randomUserDataWebClient")
	@Autowired
	WebClient randomUserDataWebClient;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "OK";
	}

	public void testSomethingElse() {
		while (true) {
			try {
				Thread.sleep(5000);
				NewAccountRequest request = new NewAccountRequest();
				
				NewAccountRequest response = createNewAccount(request);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private NewAccountRequest createNewAccount(NewAccountRequest request) {
		String newAccountUrl = "http://localhost:8100/charger-network-manager/apply-for-new-account";
//		ResponseEntity<String> response = restTemplate.getForEntity(newAccountUrl + "/1", String.class);
//		System.out.println(response.toString());
		
//		return new NewAccountResponse();
		return null;
	}

	
	
}
