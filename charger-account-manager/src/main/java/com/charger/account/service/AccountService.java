package com.charger.account.service;

import org.springframework.stereotype.Service;

import com.charger.account.common.Account;
import com.charger.account.common.ChargerApplicant;

@Service
public class AccountService {

	//TODO: this needs actual implementation
	public Account createNewAccount(ChargerApplicant newApplicant) {
		Account acct = applicantToAccount(newApplicant);
		
		return acct;
	}
	
	private Account applicantToAccount(ChargerApplicant newApplicant) {
		Account acct = new Account();
		
//		acct.set_id(1L);
		acct.setRequestedDate("Oct-3-2018");
		acct.setDateCreated("Oct-3-2018");
		acct.setAddress(newApplicant.getAddress());
		acct.setAge(38);
		acct.setEmail(newApplicant.getEmail());
		acct.setFirstName(newApplicant.getFirstName());
		acct.setLastName(newApplicant.getLastName());
		acct.setSsn(newApplicant.getSsn());
		
		return acct;
	}
	
}
