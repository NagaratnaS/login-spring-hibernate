package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.RegistrationDTO;
import com.wolken.wolkenapp.entity.RegistartionEntity;

public interface RegistrationDAO {
	public String addAndSave(RegistartionEntity entity) throws SessionException, TransactionException ;
	public RegistartionEntity getUserByUserName(String userName);
	 public int updateByEmailID(RegistrationDTO dto);

}
