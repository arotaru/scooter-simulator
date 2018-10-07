package com.charger.discovery.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ChargerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargerDiscoveryApplication.class, args);
	}
}
