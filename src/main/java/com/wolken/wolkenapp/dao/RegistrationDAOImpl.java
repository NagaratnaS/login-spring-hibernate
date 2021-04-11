package com.wolken.wolkenapp.dao;

import java.util.logging.Logger;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.RegistrationDTO;
import com.wolken.wolkenapp.entity.RegistartionEntity;

@Component
public class RegistrationDAOImpl implements RegistrationDAO {
	RegistartionEntity entity = new RegistartionEntity();
	Logger logger = Logger.getLogger("RegistrationDAOImpl");
	@Autowired
	LocalSessionFactoryBean bean;

	@Override
	public String addAndSave(RegistartionEntity entity) throws SessionException, TransactionException {
		// TODO Auto-generated method stub
		logger.info("GOT THE DATA FROM THE SERVICE AND PROCESSIONG IT");
		SessionFactory factory = null;
		try {
			factory = bean.getObject();
		} catch (Exception e) {
			throw new SessionException("Some error occured while creating the session!!");
		}
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			throw new TransactionException("Some error occured while creating the transaction");
		}
		session.close();
		logger.info("SESSION CLOSED");
		return "data added";
	}
	
	
	  public RegistartionEntity getUserByUserName(String userName) { 
		  logger.info("Entered getUserByUserName of DAOImpl with username="+userName);
		  SessionFactory factory = bean.getObject();
		  Session session = factory.openSession();
		  Transaction transaction = session.beginTransaction() ; 
		  Query query = session.createQuery(" from RegistartionEntity le where le.userName =:userName");
		  query.setParameter("userName", userName); 
		  RegistartionEntity entity = (RegistartionEntity)query.uniqueResult(); 
		  return entity;
	 
	  }
	  
	  public int updateByEmailID(RegistrationDTO dto) {
		  logger.info("Inside updateByEmailId method of LoginDAOImpl");
			SessionFactory factory = bean.getObject();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query upQ = session.createQuery("update RegistartionEntity pe set pe.userName= :userName, pe.dateOfBirth= :dateOfBirth where pe.emailID= :emailID");
			upQ.setParameter("userName",dto.getUserName());
			upQ.setParameter("dateOfBirth",dto.getDateOfBirth());
			upQ.setParameter("emailID", dto.getEmailID());
			int result = upQ.executeUpdate();
			transaction.commit();
			session.close();

			logger.info("End of updateByEmailId method of LoginDAOImpl\n");
			return result;
	  }
	 
	
	/*
	 * public LoginEntity updateUserByEmailID(String emailID) { SessionFactory
	 * factory = bean.getObject(); Session session = factory.openSession();
	 * Transaction transaction = session.beginTransaction(); Query query = session.
	 * createQuery("update LoginEntity le set cno =: contact_number where le.userName =:userName"
	 * ); LoginEntity entity = (LoginEntity)query.uniqueResult(); return entity; }
	 * 
	 * public LoginEntity updateUserByContactNumber(long contact_number) {
	 * SessionFactory factory = bean.getObject(); Session session =
	 * factory.openSession(); Transaction transaction = session.beginTransaction();
	 * Query query = session.
	 * createQuery("update LoginEntity le set uname =: userName where le.contact_number =:contact_number"
	 * ); LoginEntity entity = (LoginEntity)query.uniqueResult(); return entity; }
	 */

}
