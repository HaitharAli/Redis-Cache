package com.redis.products.service;

import com.redis.products.dto.ProductInputDto;
import com.redis.products.dto.ProductResponse;

public interface ProductService {

	ProductResponse findById(Long id);
	
	ProductResponse saveUser(ProductInputDto productInputDto);

}
