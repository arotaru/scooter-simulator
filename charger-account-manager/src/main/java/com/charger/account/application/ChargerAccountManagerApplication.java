package com.charger.account.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.charger.account"})
public class ChargerAccountManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargerAccountManagerApplication.class, args);
	}
}
