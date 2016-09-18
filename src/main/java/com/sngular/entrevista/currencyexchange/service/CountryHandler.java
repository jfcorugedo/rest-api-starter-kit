package com.sngular.entrevista.currencyexchange.service;

import com.sngular.entrevista.currencyexchange.dto.Country;

/**
 * This component is in charge of obtaining all the data related to a given country
 * 
 * @author juanfernandez-corugedo
 *
 */
public interface CountryHandler {

	/**
	 * Obtains all the data about the given country
	 * @param countryCode Country code
	 * @return 
	 */
	Country getInfo(String countryCode);
}
