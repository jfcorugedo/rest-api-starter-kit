package com.sngular.entrevista.currencyexchange.service;

/**
 * This component is in charge of getting the currency exchange rate between two currency codes
 * 
 * @author juanfernandez-corugedo
 *
 */
public interface CurrencyRateHandler {

	/**
	 * Returns the currency rate between the base currency and the destination currency.
	 * 
	 * @param baseCurrencyCode Original currency that will be transformed in another currency
	 * @param destCurrencyCode Destination currency used to calculete the exchange rate 
	 * @return
	 */
	Double get(String baseCurrencyCode, String destCurrencyCode);
}
