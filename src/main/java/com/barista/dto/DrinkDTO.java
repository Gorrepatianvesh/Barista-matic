package com.barista.dto;

public class DrinkDTO {
	private Double price;
	private String name;
	
	
	public DrinkDTO(Double price, String name) {
		this.price = price;
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
