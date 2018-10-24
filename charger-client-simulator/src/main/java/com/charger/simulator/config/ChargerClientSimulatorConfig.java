package com.charger.simulator.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.charger.simulator.client.ChargerApplicantClient;

@Configuration
public class ChargerClientSimulatorConfig {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean 
	public ChargerApplicantClient chargerApplicantClient() {
		return new ChargerApplicantClient();
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
