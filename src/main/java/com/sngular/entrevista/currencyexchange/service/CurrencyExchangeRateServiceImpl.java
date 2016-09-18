package com.sngular.entrevista.currencyexchange.service;

import org.springframework.stereotype.Service;

import com.sngular.entrevista.currencyexchange.dto.Country;
import com.sngular.entrevista.currencyexchange.dto.CurrencyExchangeRate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CurrencyExchangeRateServiceImpl implements CurrencyExchangeRateService {

	private CountryHandler countryHandler;
	private CurrencyRateHandler currencyRateHandler;
	
	public CurrencyExchangeRateServiceImpl(CountryHandler countryHandler, CurrencyRateHandler currencyRateHandler) {
		this.countryHandler = countryHandler;
		this.currencyRateHandler = currencyRateHandler;
	}
	
	@Override
	public CurrencyExchangeRate compute(String baseCountryCode, String destCountryCode) {
		
		Country baseCountry = countryHandler.getInfo(baseCountryCode);
		log.debug(String.format("Base country: %s", baseCountry));
		
		Country destCountry = countryHandler.getInfo(destCountryCode);
		log.debug(String.format("Dest country: %s", destCountry));
		
		Double exchangeRate = currencyRateHandler.get(baseCountry.getCurrency(), destCountry.getCurrency());
		log.debug(String.format("Exchange rate: %f", exchangeRate));
		
		
		return new CurrencyExchangeRate()
					.setSourceCurrencyCode(baseCountry.getCurrency())
					.setDestCurrencyCode(destCountry.getCurrency())
					.setExchangeRate(exchangeRate);
	}
}
