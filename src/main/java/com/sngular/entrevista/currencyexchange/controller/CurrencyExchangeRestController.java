package com.sngular.entrevista.currencyexchange.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sngular.entrevista.currencyexchange.dto.CurrencyExchangeRate;
import com.sngular.entrevista.currencyexchange.service.CurrencyExchangeRateService;

@RestController
@RequestMapping(value="api/v1/exchange", method=GET)
public class CurrencyExchangeRestController {

	private CurrencyExchangeRateService service;
	
	public CurrencyExchangeRestController(CurrencyExchangeRateService service) {
		this.service = service;
	}
	
	@RequestMapping(method=GET)
	public ResponseEntity<CurrencyExchangeRate> getExchangeRate(@RequestParam String baseCountryCode, @RequestParam String destCountryCode) {
		
		
		return ResponseEntity.ok(service.compute(baseCountryCode, destCountryCode));
	}
}
