package com.sngular.entrevista.currencyexchange.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sngular.entrevista.currencyexchange.dto.Country;

/**
 * Implementation of CountryHandler that obtains all the data from a public REST API: https://restcountries.eu/
 * 
 * @author juanfernandez-corugedo
 *
 */
@Component
public class RestCountryHandler implements CountryHandler {

	private static final String RESTCOUNTRIESEU_COUNTRY_ENDPOINT = "http://restcountries.eu/rest/v1/alpha/%s";
	
	private RestTemplate restTemplate;
	
	public RestCountryHandler(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Country getInfo(String countryCode) {
		
		ResponseEntity<Map> response = restTemplate.getForEntity(String.format(RESTCOUNTRIESEU_COUNTRY_ENDPOINT, countryCode), Map.class);
		Map countryData = response.getBody();
		
		String currency = ((List<String>)countryData.get("currencies")).get(0);
		
		return new Country().setCurrency(currency);
	}

	
}
