package com.sngular.entrevista.currencyexchange.service;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.sngular.entrevista.currencyexchange.dto.Country;
import com.sngular.entrevista.currencyexchange.dto.CurrencyExchangeRate;
import static org.assertj.core.api.Assertions.*;

public class CurrencyExchangeRateServiceImplTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	private CountryHandler countryHandler;
	
	@Mock
	private CurrencyRateHandler currencyRateHandler;
	
	@Test
	public void givenTwoCountries_itWillReturnExchangeRate() {
		//given
		prepareMocks("EUR", "USD", 1.1326);
		CurrencyExchangeRateService service = new CurrencyExchangeRateServiceImpl(countryHandler, currencyRateHandler);
		String sourceCountryCode = "ESP";
		String destinyCountryCode = "USA";
		
		//when
		CurrencyExchangeRate result = service.compute(sourceCountryCode, destinyCountryCode);
		
		//then
		assertThat(result).isNotNull();
		assertThat(result.getExchangeRate()).isEqualTo(1.1326);
		assertThat(result.getSourceCurrencyCode()).isEqualTo("EUR");
		assertThat(result.getDestCurrencyCode()).isEqualTo("USD");
	}

	private void prepareMocks(String baseCurrencyCode, String destCurrencyCode, Double exchangeRate) {
		when(countryHandler.getInfo(anyString()))
			.thenReturn(new Country().setCurrency(baseCurrencyCode))
			.thenReturn(new Country().setCurrency(destCurrencyCode));
		
		when(currencyRateHandler.get(baseCurrencyCode, destCurrencyCode)).thenReturn(exchangeRate);
	}
}
