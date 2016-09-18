package com.sngular.entrevista.currencyexchange.service;

import com.sngular.entrevista.currencyexchange.dto.CurrencyExchangeRate;

/**
 * Obtains the currency exchange rate between two different countries.
 * If any of the countries has more than one currency, it only takes 
 * into account the primary currency of each country
 * 
 * @author juanfernandez-corugedo
 *
 */
public interface CurrencyExchangeRateService {

	/**
	 * Given an origin country and a destiny country, it returns the currency exchange rate between the 
	 * currency of each country.
	 * 
	 * @param baseCountryCode Country code used to obtain the origin currency to compute the exchange rate
	 * @param destCountryCode Country code used to obtain the destination currency to compute the exchange rate
	 * @return Exchange rate between these two countries
	 */
	CurrencyExchangeRate compute(String baseCountryCode, String destCountryCode);

}
