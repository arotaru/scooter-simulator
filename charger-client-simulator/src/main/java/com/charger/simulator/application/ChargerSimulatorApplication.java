package com.charger.simulator.application;

import java.util.Collections;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.scooter.common.ChargerApplicant;
import com.scooter.common.NewAccountResponse;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.charger" })
public class ChargerSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargerSimulatorApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();
		String chargerAccountAPIServerUrl = "http://charger-network-gateway:8100/";
		String serviceName = "charger-network-manager";
		String applyForAccountEndpoint = "/apply-for-new-account";
		
		String applyForAccountUrl = chargerAccountAPIServerUrl + serviceName + applyForAccountEndpoint;
		String randomUserUrl = "https://randomuser.me/api/?nat=us";
		
		try {
			Thread.sleep(90000);
			
			String urlToWakeZuulUp = chargerAccountAPIServerUrl + serviceName + "/test";
			ResponseEntity<String> testResponse = restTemplate.getForEntity(urlToWakeZuulUp, String.class);
			
			Thread.sleep(90000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while (true) {
			ResponseEntity<String> getRandomUserResponse = restTemplate.getForEntity(randomUserUrl, String.class);
			JSONObject jsonObj = new JSONObject(getRandomUserResponse.getBody());

			if (jsonObj != null) {
				ChargerApplicant applicant = new ChargerApplicant(jsonObj);

				if (applicant.isCreatedSuccessfully()) {
					// apply
					ResponseEntity<NewAccountResponse> response = 
							restTemplate.postForEntity(applyForAccountUrl, applicant,  NewAccountResponse.class);
					System.out.println(response.getBody().toString());
				}
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Bean(name = "chargerAccountsWebClient")
	public WebClient chargerAccountsWebClient() {
		return WebClient.builder().baseUrl("http://localhost:8100").defaultCookie("cookieKey", "cookieValue")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8100")).build();
	}

	@Bean(name = "randomUserDataWebClient")
	public WebClient randomUserDataWebClient() {
		return WebClient.create();
	}

}
