package com.sngular.entrevista.currencyexchange.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of CurrencyRateHandler that obtains all the data about currency exchage rate from a public REST API: http://api.fixer.io
 * 
 * @author juanfernandez-corugedo
 *
 */
@Component
public class RestCurrencyRateHandler implements CurrencyRateHandler {

	private static final String FIXERIO_RATE_ENDPOINT = "http://api.fixer.io/latest?base=%s&symbols=%s";
	private RestTemplate restTemplate;
	
	public RestCurrencyRateHandler(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Double get(String baseCurrencyCode, String destCurrencyCode) {
		
		ResponseEntity<Map> response = 
				restTemplate.getForEntity(
						String.format(FIXERIO_RATE_ENDPOINT, baseCurrencyCode, destCurrencyCode), Map.class);
		
		return ((Map<String, Double>)response.getBody().get("rates")).get(destCurrencyCode);
	}

}
