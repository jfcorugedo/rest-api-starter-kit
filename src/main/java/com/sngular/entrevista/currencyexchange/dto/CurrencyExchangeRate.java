package com.sngular.entrevista.currencyexchange.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * This DTO represents the current exchange rate between two different currencies.
 * 
 * @author juanfernandez-corugedo
 *
 */
@Data
@NoArgsConstructor
@Accessors(chain=true)
public class CurrencyExchangeRate {//NOSONAR

	private String sourceCurrencyCode;
	private String destCurrencyCode;
	private Double exchangeRate;
}
