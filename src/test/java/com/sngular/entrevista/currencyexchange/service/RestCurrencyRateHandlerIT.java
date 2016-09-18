package com.sngular.entrevista.currencyexchange.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

@Ignore("It requires internet connection to test fixer.io endpoint")
public class RestCurrencyRateHandlerIT {

	@Test
	public void givenEURandUSD_itWillReturnRealExchangeRate() {
		//given
		CurrencyRateHandler currencyRateHandler = new RestCurrencyRateHandler(new RestTemplate());
		String baseCurrencyCode = "EUR";
		String destCurrencyCode = "USD";
		
		//when
		Double exchangeRate = currencyRateHandler.get(baseCurrencyCode, destCurrencyCode);
		
		//then
		assertThat(exchangeRate).isNotNull();
	}
}
