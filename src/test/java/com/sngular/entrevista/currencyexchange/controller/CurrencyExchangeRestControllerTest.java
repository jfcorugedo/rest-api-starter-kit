package com.sngular.entrevista.currencyexchange.controller;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.sngular.entrevista.currencyexchange.dto.CurrencyExchangeRate;
import com.sngular.entrevista.currencyexchange.service.CurrencyExchangeRateService;

public class CurrencyExchangeRestControllerTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	private CurrencyExchangeRateService service;
	
	@Test
	public void givenESPandGBR_whenGetExchangeRate_itWillReturnsValidValue() {
	
		prepareExchageServiceMock();
		
		given()
			.standaloneSetup(new CurrencyExchangeRestController(service)).
		when()
			.get("api/v1/exchange?baseCountryCode=ESP&destCountryCode=GBR").
		then()
			.statusCode(200)
			.body("sourceCurrencyCode", equalTo("EUR"))
			.and().body("destCurrencyCode", equalTo("GBP"))
			.and().body("exchangeRate", equalTo(0.83535f));
	}

	private void prepareExchageServiceMock() {
		
		when(service.compute("ESP", "GBR"))
			.thenReturn(
					new CurrencyExchangeRate()
						.setSourceCurrencyCode("EUR")
						.setDestCurrencyCode("GBP")
						.setExchangeRate(0.83535)
			);
	}
	
}
