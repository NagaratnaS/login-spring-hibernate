package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.ProductsDTO;
import com.wolken.wolkenapp.entity.ProductsEntity;

public interface ProductsService {

	public String validateAndAdd(ProductsDTO dto);
	public List<ProductsEntity> validateAndGetProductByType(String type);
}
