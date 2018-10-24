package com.charger.simulator.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.charger.simulator.client.ChargerApplicantClient;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.charger.simulator" })
public class ChargerSimulatorApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ChargerSimulatorApplication.class, args);
		
		ChargerApplicantClient client = (ChargerApplicantClient) context.getBean("chargerApplicantClient");
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		
		client.setRestTemplate(restTemplate);
		client.run();
	}

}
