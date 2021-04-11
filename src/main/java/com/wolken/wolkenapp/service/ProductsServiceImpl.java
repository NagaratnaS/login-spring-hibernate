package com.wolken.wolkenapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dao.ProductsDAO;
import com.wolken.wolkenapp.dto.ProductsDTO;
import com.wolken.wolkenapp.entity.ProductsEntity;


@Service
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	ProductsDAO dao;
	@Autowired
	ProductsEntity entity;
	
	@Override
	public List<ProductsEntity> validateAndGetProductByType(String type) {
		// TODO Auto-generated method stub
		if (!type.equals(null)) {
			return dao.getProductByType(type);
		}
		return null;
	}

	@Override
	public String validateAndAdd(ProductsDTO dto) {
		// TODO Auto-generated method stub
		if (dto != null) {
			if (dto.getProductID() > 0 && !dto.getProductName().equals(null) && !dto.getType().equals(null) && dto.getPrice() > 0) {
				entity.setProductID(dto.getProductID());
				entity.setProductName(dto.getProductName());
				entity.setType(dto.getType());
				entity.setPrice(dto.getPrice());
				String message = dao.addProducts(entity);
				return message;
			}
		}
		return "Addition operation failed";
	}

}
