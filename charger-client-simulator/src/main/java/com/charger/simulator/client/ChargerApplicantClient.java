package com.charger.simulator.client;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.charger.simulator.common.NewAccountRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChargerApplicantClient {
	
	private RestTemplate restTemplate;
	
	String apiGatewayUrl = "http://charger-network-gateway:8100/";
	String serviceName = "charger-network-manager";
	String applyForAccountEndpoint = "/apply-for-new-account";

	String applyForNewAccountUrl = apiGatewayUrl + serviceName + applyForAccountEndpoint;
	String randomUserUrl = "https://randomuser.me/api/?nat=us";
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void run() {
		wakeUpZuul();
		simulateChargerApplications();
	}
	
	private void wakeUpZuul() {
		try {
			// TODO:
			/*
			 * I noticed that the API Gateway starts responding after this log print:
			 * 2018-10-22 03:37:24.023 INFO 11 --- [erListUpdater-0]
			 * c.netflix.config.ChainedDynamicProperty : Flipping property:
			 * charger-network-manager.ribbon.ActiveConnectionsLimit to use NEXT property:
			 * niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit =
			 * 2147483647
			 */
			Thread.sleep(90000);

			String urlToWakeZuulUp = apiGatewayUrl + serviceName + "/test";
			String testResponse = restTemplate.getForObject(urlToWakeZuulUp, String.class);
			
			System.out.println("Made initial call through Zuul which triggers the set up of routes; response: " + testResponse);

			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void simulateChargerApplications() {
		ObjectMapper mapper = new ObjectMapper();

		while (true) {
			String randomUser = restTemplate.getForObject(randomUserUrl, String.class);
			JSONObject randomUserJson = new JSONObject(randomUser);

			if (randomUserJson != null) {
				NewAccountRequest newAccountRequest = new NewAccountRequest(randomUserJson);
				
				String applicant = null;
				
				try {
					applicant = mapper.writeValueAsString(newAccountRequest);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				
				if (applicant != null) {
					System.out.println("SENDING THIS REQUEST: " + applicant);
					String response = restTemplate.postForObject(applyForNewAccountUrl, applicant, String.class);

					System.out.println(response);
				}
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
