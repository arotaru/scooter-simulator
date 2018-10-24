package com.charger.network.web.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.charger.network.common.NewAccountRequest;
import com.charger.network.service.NewAccountService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String applyForNewAccount(@RequestBody String jsonObj) {
		System.out.println("Network Manager Controller - received an /apply-for-new-account request");
		
		//TODO: Put charger-accounts-account-manager in a properties file?
		String newAccountServiceUrl = getServiceUrl("charger-account-manager");
		
		//TODO: put /apply-for-new-account in a properties file?
		
		//TODO: Notice that here you're sending directly to the service, and not going through the
		//      API GAteway, like in the ChargerSimulatorApplication...
		String url = newAccountServiceUrl + "/apply-for-new-account";
		
		System.out.println("Sending to: " + newAccountServiceUrl);
		
		ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
		restTemplate.setRequestFactory(requestFactory);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		NewAccountRequest newAccountRequest = null;
		
		try {
			newAccountRequest = mapper.readValue(jsonObj, NewAccountRequest.class);
		} catch (JsonParseException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (newAccountRequest == null) {
				newAccountRequest = new NewAccountRequest();
			}
		}
		
		System.out.println("Sending directly to " + url + " bypassing API Gateway; should fix this...");
		
		String request = "";
		
		try {
			request = mapper.writeValueAsString(newAccountRequest);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String jsonResponseObj = restTemplate.postForObject(url, request, String.class);
		
		System.out.println("Charger-Network-Manager received: " + jsonResponseObj);
		
		return jsonResponseObj;
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
