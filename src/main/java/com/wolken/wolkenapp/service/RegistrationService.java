package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.RegistrationDTO;
import com.wolken.wolkenapp.entity.RegistartionEntity;

public interface RegistrationService {
	public String validateAndAdd(RegistrationDTO dto) throws DTONullException, InvalidInputException, TransactionException, SessionException, TransactionException;
	public String validateAndUpdateByEmailID(RegistrationDTO dto);
	public RegistartionEntity validateAndGetUserByUserName(String userName);
	

}
