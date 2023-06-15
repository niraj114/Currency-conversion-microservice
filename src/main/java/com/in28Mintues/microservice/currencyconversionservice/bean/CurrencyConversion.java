package com.in28Mintues.microservice.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	public long id;
	public String from;
	public String to;
	public BigDecimal conversionMultiple;
	public BigDecimal qty;
	public BigDecimal totalCalculatedAmount;
	public String env;
		
	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversion(long id, String from, String to, BigDecimal qty,BigDecimal conversionMultiple,
			BigDecimal totalCalculatedAmount, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.qty = qty;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.env = env;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	
	

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", qty=" + qty + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", enviroment=" + env + "]";
	}
	
	

}
