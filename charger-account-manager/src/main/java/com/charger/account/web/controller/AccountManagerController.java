package com.charger.account.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charger.account.service.AccountService;
import com.scooter.common.ChargerApplicant;
import com.scooter.common.NewAccountResponse;

@RestController
public class AccountManagerController {
	
	@Autowired
	private AccountService acctService;

	@RequestMapping(value = "/testingAccountMgr", method = RequestMethod.GET)
	public String test() {
		return "OK from AccountManagerController.test()";
	}
	
	@RequestMapping(value = "/apply-for-new-account", method = RequestMethod.POST)
	public NewAccountResponse applyForNewAccount(@RequestBody ChargerApplicant newAccountRequest) {
		NewAccountResponse response = new NewAccountResponse();
		response.setNewAccountCreated(true);
		response.setNewAccountUrl("http://path.to.new.account");
		response.setAccount(acctService.createNewAccount(newAccountRequest));
		
		return response;
	}
	
}
