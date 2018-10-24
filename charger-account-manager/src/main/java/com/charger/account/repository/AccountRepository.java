package com.charger.account.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charger.account.common.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	Account findBy_id(ObjectId _id);
	
}
