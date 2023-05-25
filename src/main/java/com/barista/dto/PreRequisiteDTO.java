package com.barista.dto;

public class PreRequisiteDTO {
	private Double price;
	private Integer quantity;
	
	
	public PreRequisiteDTO(Double price, Integer quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
