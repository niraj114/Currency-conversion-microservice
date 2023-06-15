package com.in28Mintues.microservice.currencyconversionservice.rest;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28Mintues.microservice.currencyconversionservice.bean.CurrencyConversion;
import com.in28Mintues.microservice.currencyconversionservice.bean.CurrencyExchangeProxy;

@RestController
public class CurrencyCoversionController {
	
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrency(
			@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity
			) {
		
		HashMap<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		System.out.println("1");
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariable);

		
		CurrencyConversion curnConversion = responseEntity.getBody();
		
		System.out.println(curnConversion);
		
		return new CurrencyConversion(curnConversion.getId(),curnConversion.getFrom(), curnConversion.getTo(),quantity ,curnConversion.getConversionMultiple(), quantity.multiply(curnConversion.getConversionMultiple()), curnConversion.getEnv()+"from Restremplayte");
		
	}
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyFeign(
			@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity
			) {
		
		
		CurrencyConversion curnConversion = currencyExchangeProxy.retrieveExchnageValue(from, to);

		return new CurrencyConversion(curnConversion.getId(),curnConversion.getFrom(), curnConversion.getTo(),quantity ,curnConversion.getConversionMultiple(), quantity.multiply(curnConversion.getConversionMultiple()), curnConversion.getEnv()+"from fein");
		
	}

}
