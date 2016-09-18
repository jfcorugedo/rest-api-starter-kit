package com.sngular.entrevista.currencyexchange.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.sngular.entrevista.util.CollectionUtils.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sngular.entrevista.currencyexchange.dto.Country;

import java.util.Map;

public class RestCountryHandlerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	private RestTemplate restTemplate;
	
	@Test
	public void givenCountryCode_itWillReturnCountryData() {
		//given
		prepareMock("EUR");
		CountryHandler countryHandler = new RestCountryHandler(restTemplate);
		String countryCode = "ESP";
		
		//when
		Country result = countryHandler.getInfo(countryCode);
		
		//then
		assertThat(result).isNotNull();
	}
	
	@Test
	public void givenSpain_itWillReturnsSpainCurrency() {
		//given
		prepareMock("EUR");
		CountryHandler countryHandler = new RestCountryHandler(restTemplate);
		String countryCode = "ESP";
		
		//when
		Country result = countryHandler.getInfo(countryCode);
		
		//then
		assertThat(result).isNotNull();
		assertThat(result.getCurrency()).isEqualTo("EUR");
	}

	@SuppressWarnings("rawtypes")
	private void prepareMock(String... currencies) {
		when(restTemplate.getForEntity(anyString(), eq(Map.class)))
				.thenReturn(new ResponseEntity<Map>(newMap("currencies", newList(currencies)), HttpStatus.OK));
	}
}
