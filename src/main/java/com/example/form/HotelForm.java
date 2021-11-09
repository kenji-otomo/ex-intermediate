package com.example.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class HotelForm {

	//@Pattern(regexp = "\\d{1,13}")
	@Range(min = 0,max = 999999999)
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}
	
}
