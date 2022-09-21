package com.redis.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.products.dto.ProductInputDto;
import com.redis.products.dto.ProductResponse;
import com.redis.products.service.ProductService;

@RestController
@RequestMapping("product")
@EnableCaching
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/findById/{id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
		ProductResponse resp = productService.findById(id);
		return new ResponseEntity<ProductResponse>(resp, HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<ProductResponse> addUser(@RequestBody ProductInputDto productInputDto) {
		ProductResponse resp = productService.saveUser(productInputDto);
		return new ResponseEntity<ProductResponse>(resp, HttpStatus.OK);
	}
}
