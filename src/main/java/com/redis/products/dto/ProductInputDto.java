package com.redis.products.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductInputDto implements Serializable{

	private static final long serialVersionUID = 6541768314723052159L;
	/**
	 * 
	 */
	private String productName;
	private String qty;
	private double price;
}
