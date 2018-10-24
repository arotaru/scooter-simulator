package com.charger.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
@ComponentScan(basePackages = {"com.charger.account"})
@EnableMongoRepositories(basePackages = "com.charger.account.repository")
public class MongoConfig { // extends AbstractMongoConfiguration {

//	@Override
//    protected String getDatabaseName() {
//        return "charger";
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return new MongoClient("127.0.0.1", 27017);
//    }
//
//    @Override
//    public String getMappingBasePackage() {
//        return "com.charger.account";
//    }
	
//	@Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
// 
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        return new SimpleMongoDbFactory(mongoClient, "charger");
// 
//    }
// 
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
// 
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//        return mongoTemplate;
// 
//    }
	
	@Bean
    public MongoClientOptions mongoClientOptions() {
        return MongoClientOptions.builder()
                // timeout for selecting a server to execute operation on
                .serverSelectionTimeout(3000)
                // after server selection, tries to connect to server
                .socketTimeout(3000)
                .build();
    }
	
}
