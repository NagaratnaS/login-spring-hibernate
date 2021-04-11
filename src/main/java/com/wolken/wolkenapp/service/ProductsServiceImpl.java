package com.wolken.wolkenapp.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.dao.ProductsDAO;
import com.wolken.wolkenapp.dto.ProductsDTO;
import com.wolken.wolkenapp.entity.ProductsEntity;


@Service
public class ProductsServiceImpl implements ProductsService{
	Logger logger = Logger.getLogger("validateAndUpdateByEmailID");

	@Autowired
	ProductsDAO dao;
	@Autowired
	ProductsEntity entity;
	
	@Override
	public List<ProductsEntity> validateAndGetProductByType(String type) {
		// TODO Auto-generated method stub
		logger.info("Entered the validateAndGetProductByType method and processing it");
		if (!type.equals(null)) {
			return dao.getProductByType(type);
		}
		return null;
	}

	@Override
	public String validateAndAdd(ProductsDTO dto) {
		// TODO Auto-generated method stub
		logger.info("Entered the validateAndAdd method and processing it");
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
