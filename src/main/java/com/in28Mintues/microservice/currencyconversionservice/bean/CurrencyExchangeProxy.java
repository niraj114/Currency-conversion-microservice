package com.in28Mintues.microservice.currencyconversionservice.bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange-service1", url="localhost:8000")
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchnageValue(
			@PathVariable("from") String from, 
			@PathVariable("to") String to);
	

}
