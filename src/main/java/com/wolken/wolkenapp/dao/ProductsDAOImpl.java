package com.wolken.wolkenapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dto.ProductsDTO;
import com.wolken.wolkenapp.entity.ProductsEntity;
import com.wolken.wolkenapp.entity.RegistartionEntity;

@Component
public class ProductsDAOImpl implements ProductsDAO{

	Logger logger = Logger.getLogger("ProductsDAOImpl");
	@Autowired
	LocalSessionFactoryBean bean;
	
	@Autowired
	ProductsEntity entity;
	
	@Override
	public String addProducts(ProductsEntity entity) {
		logger.info("Entered ProductsDAOImpl add method");
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		factory = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
		return "Product addded succesfully";
		
		
	}

	@Override
	public List<ProductsEntity> getProductByType(String type) {
		// TODO Auto-generated method stub
		logger.info("Entered ProductsDAOImpl getProductByType method with type="+type);
		SessionFactory factory = bean.getObject();
		  Session session = factory.openSession();
		  Transaction transaction = session.beginTransaction() ; 
		  Query query = session.createQuery(" from ProductsEntity le where le.type =:type");
		  query.setParameter("type", type); 
		  List<ProductsEntity> entityList = query.list(); 
		  return entityList;
		
	}

}
