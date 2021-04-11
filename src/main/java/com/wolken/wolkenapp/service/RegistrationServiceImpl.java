package com.wolken.wolkenapp.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dao.RegistrationDAO;
import com.wolken.wolkenapp.dto.RegistrationDTO;
import com.wolken.wolkenapp.entity.RegistartionEntity;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	Logger logger = Logger.getLogger("LoginServiceImpl");
	@Autowired
	RegistartionEntity entity;
	
	@Autowired
	RegistrationDAO dao;
	@Autowired
	RegistrationDTO dto;
	

	@Override
	public String validateAndAdd(RegistrationDTO dto)throws DTONullException,InvalidInputException,TransactionException,SessionException {
		// TODO Auto-generated method stub
		// 
		logger.info("Entered Validate and add method processing it");
		if(dto != null) {
			if(dto.getContact_number() > 0 && !dto.getDateOfBirth().equals(null) && !dto.getEmailID().equals(null) && !dto.getGender().equals(null) && !dto.getUserName().equals(null) && !dto.getPassword().equals(null) ) {
				
				entity = dao.getUserByUserName(dto.getUserName());
				if(entity != null) {
					return "user already exists";
				}
				else {
					RegistartionEntity entity=new RegistartionEntity();
			
					logger.info("VALIDATE AND ALL THE DETAILS");
					entity.setContact_number(dto.getContact_number());
					entity.setDateOfBirth(dto.getDateOfBirth());
					entity.setEmailID(dto.getEmailID());
					entity.setGender(dto.getGender());
					entity.setUserName(dto.getUserName());
					entity.setPassword(dto.getPassword());
					entity.setConfirmPassword(dto.getConfirmPassword());
					return dao.addAndSave(entity);
					
				}
		
			}
			throw new InvalidInputException("Invalid Input!! Please enter the valid Input");
		}
		throw new DTONullException("DTO is Null!! Operations Cannot be performed");
	}
	
	public RegistartionEntity validateAndGetUserByUserName(String userName) {
		//validate the parameter
		logger.info("entered validateAndGetUserByUserName method and processing it...");
		entity = null;
		if(!userName.equals(null)) {
			entity = dao.getUserByUserName(userName);
		}
		
		return entity;
	}
	
	public String validateAndUpdateByEmailID(RegistrationDTO dto) {
		// Validate the parameter
		logger.info("entered validateAndUpdateByEmailID method and processing it...");
		int noOfRowsUpdated = -1;
		if(!dto.getEmailID().equals(null)) {
			// call daoimpl method
			noOfRowsUpdated = dao.updateByEmailID(dto);
		}
		
		// validate the value  returned by dao method 
		if(noOfRowsUpdated >= 1) {
			return "Values are successfully updated";
		}
		else if(noOfRowsUpdated == 0) {
			return "none of the rows are updated";
		}
		return "Some error occured";
		// return to controller

	}

}

