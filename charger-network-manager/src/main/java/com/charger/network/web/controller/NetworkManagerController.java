package com.charger.network.web.controller;

import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.charger.network.service.NewAccountService;
import com.scooter.common.ChargerApplicant;
import com.scooter.common.NewAccountResponse;

@RestController
public class NetworkManagerController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private NewAccountService newAccountService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "OK";
	}
	
	@RequestMapping(value = "/check-availability", method = RequestMethod.GET)
	public String checkChargerAvailability() {
		// check database and return Spots Available or No Spots Available
		
		return "{ availability : wait-list }";
	}
	
	@RequestMapping(value = "/apply-for-new-account", method = RequestMethod.POST)
	public NewAccountResponse applyForNewAccount(@RequestBody ChargerApplicant chargerApplicant) {
		System.out.println("Got the request");
		
		//TODO: Put charger-accounts-account-manager in a properties file?
		String newAccountServiceUrl = getServiceUrl("charger-account-manager");
		
		//TODO: put /apply-for-new-account in a properties file?
		String url = newAccountServiceUrl + "/apply-for-new-account";
		
		ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
		restTemplate.setRequestFactory(requestFactory);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		 
		HttpEntity<ChargerApplicant> request = new HttpEntity<>(chargerApplicant, headers);
		NewAccountResponse response = restTemplate.postForObject(url, request, NewAccountResponse.class);
		
		return response;
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 60000;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }
	
	private String getServiceUrl(String serviceName) {
		List<String> services = discoveryClient.getServices();
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
		
		if (serviceInstances != null && serviceInstances.size() > 0) {
			return serviceInstances.get(0).getUri().toString();
		}
		
		return null;
	}
	
}
