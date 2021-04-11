package com.wolken.wolkenapp.dao;


import java.util.List;

import com.wolken.wolkenapp.entity.ProductsEntity;

public interface ProductsDAO {
	public String addProducts(ProductsEntity entity);
	public List<ProductsEntity> getProductByType(String type);

}
