package com.sngular.entrevista.currencyexchange.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.sngular.entrevista.util.CollectionUtils.*;

import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestCurrencyRateHandlerTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	private RestTemplate restTemplate;
	
	@Test
	public void givenTwoCurrencyCodes_itWillReturnsAExchangeRate() {
		//given
		prepareMock(0.0);
		CurrencyRateHandler currencyRateHandler = new RestCurrencyRateHandler(restTemplate);
		String baseCurrencyCode = "EUR";
		String destCurrencyCode = "USD";
		
		//when
		Double exchangeRate = currencyRateHandler.get(baseCurrencyCode, destCurrencyCode);
		
		//then
		assertThat(exchangeRate).isNotNull();
	}
	
	@Test
	public void givenSpain_itWillReturnValidExchangeRate() {
		//given
		prepareMock(1.1326);
		CurrencyRateHandler currencyRateHandler = new RestCurrencyRateHandler(restTemplate);
		String baseCurrencyCode = "EUR";
		String destCurrencyCode = "USD";
		
		//when
		Double exchangeRate = currencyRateHandler.get(baseCurrencyCode, destCurrencyCode);
		
		//then
		assertThat(exchangeRate).isEqualTo(1.1326);
	}
	
	private void prepareMock(Double exchangeRate) {
		when(restTemplate.getForEntity(anyString(), eq(Map.class)))
			.thenReturn(new ResponseEntity<Map>(newMap("rates", newMap("USD", exchangeRate)), HttpStatus.OK));
	}
}
