package com.redis.products.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1564592425665097742L;
	private Long id;
	private String productName;
	private String qty;
	private double price;
}
