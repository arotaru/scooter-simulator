package com.charger.account.web.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charger.account.common.Account;
import com.charger.account.common.NewAccountRequest;
import com.charger.account.common.NewAccountResponse;
import com.charger.account.repository.AccountRepository;
import com.charger.account.service.AccountService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AccountManagerController {

	@Autowired
	private AccountService acctService;

	@Autowired
	private AccountRepository acctRepo;

	@RequestMapping(value = "/testingAccountMgr", method = RequestMethod.GET)
	public String test() {
		return "OK from AccountManagerController.test()";
	}

	@RequestMapping(value = "/apply-for-new-account", method = RequestMethod.POST)
	public String applyForNewAccount(@RequestBody String jsonObj) {
		System.out.println("RECEIVED THIS REQUEST: " + jsonObj);
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		NewAccountRequest newAccountRequest = null;
		
		try {
			newAccountRequest = mapper.readValue(jsonObj, NewAccountRequest.class);
		} catch (JsonParseException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NewAccountResponse response = new NewAccountResponse();

		if (newAccountRequest != null) {
			Account acct = new Account();
			
			acct.set_id(ObjectId.get());
			acct.setAddress(newAccountRequest.getAddress());
			acct.setAge(newAccountRequest.getAge());
			acct.setDateCreated(LocalDateTime.now().toString());
			acct.setEmail(newAccountRequest.getEmail());
			acct.setFirstName(newAccountRequest.getFirstName());
			acct.setLastName(newAccountRequest.getLastName());
			acct.setRequestedDate(LocalDateTime.now().toString());
			acct.setSsn(newAccountRequest.getSsn());

			acctRepo.save(acct);
			
			response.setAccountForResponse(acct);
			response.setNewAccountUrl("http://path.to.new.account");
			response.setNewAccountCreated(true);
		} else {
			response.setAccountForResponse(null);
			response.setNewAccountCreated(false);
		}
		
//		List<Account> accounts = acctRepo.findAll();
		
//		accounts.stream().forEach(element -> System.out.println(element));
		
		String responseStr = null;
		
		try {
			responseStr = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Account-Manager-Controller Returning: " + responseStr);

		return responseStr;
	}

}
