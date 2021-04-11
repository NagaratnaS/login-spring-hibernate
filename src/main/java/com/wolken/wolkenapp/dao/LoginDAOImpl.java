package com.wolken.wolkenapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.entity.LoginEntity;

@Component

public class LoginDAOImpl implements LoginDAO{
	Logger logger = Logger.getLogger("LoginDAOImpl");

	@Autowired
	LocalSessionFactoryBean bean;
	@Override
	public LoginEntity add(String userName) throws SessionException, TransactionException {
		// TODO Auto-generated method stub
		logger.info("Entered LoginDAOImpl add method with username = "+userName);
		SessionFactory  factory  = bean.getObject();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from LoginEntity le where le.userName = :userName");
		query.setParameter("userName", userName);
		LoginEntity loginEntity = (LoginEntity)query.uniqueResult();
		session.close();
		return loginEntity;
	}
	
	



}
