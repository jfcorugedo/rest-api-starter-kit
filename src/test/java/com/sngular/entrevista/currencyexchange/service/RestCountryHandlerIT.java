package com.sngular.entrevista.currencyexchange.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.sngular.entrevista.currencyexchange.dto.Country;

@Ignore("It makes an http request to a real endpoint, so it requires internet connection")
public class RestCountryHandlerIT {

	@Test
	public void givenESP_whenItCallsRestApi_itWillReturnData() {
		//given
		CountryHandler countryHandler = new RestCountryHandler(new RestTemplate());
		String countryCode = "ESP";
		
		//when
		Country result = countryHandler.getInfo(countryCode);
		
		//then
		assertThat(result.getCurrency()).isEqualTo("EUR");
	}
}
