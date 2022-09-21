package com.redis.products.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.products.advice.TrackExecutionTime;
import com.redis.products.dto.ProductInputDto;
import com.redis.products.dto.ProductResponse;
import com.redis.products.entity.Product;
import com.redis.products.repository.ProductRepository;
import com.redis.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	private ProductResponse convertProductResponse(Product product) {
		logger.info("ProductServiceImpl::convertProductResponse - Start");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		logger.info("ProductServiceImpl::convertProductResponse - End");
		return modelMapper.map(product, ProductResponse.class);
	}

	@Override
	@Cacheable(key="#id",value = "Product")
	@TrackExecutionTime
	public ProductResponse findById(Long id) {
		logger.info("ProductServiceImpl::findById - Start");
		Product product = productRepository.getById(id);
		ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
		logger.info("ProductServiceImpl::findById - End");
		return productResponse;
	}

	@Override
	@TrackExecutionTime
	public ProductResponse saveUser(ProductInputDto productInputDto) {
		Product productResp = modelMapper.map(productInputDto, Product.class);
		Product product = productRepository.save(productResp);
		return modelMapper.map(product, ProductResponse.class);
	}

}
