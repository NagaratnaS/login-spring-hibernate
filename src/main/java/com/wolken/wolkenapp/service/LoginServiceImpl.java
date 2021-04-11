package com.wolken.wolkenapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dao.LoginDAO;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.entity.LoginEntity;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO dao;

	@Override
	public String validateAndLogin(LoginDTO dto) throws SessionException, TransactionException {
		// TODO Auto-generated method stub
		if(dto != null) {
			LoginEntity entity = dao.add(dto.getUserName());
			if(entity != null) {
				if(dto.getUserName().equals(entity.getUserName())) {
					if(dto.getPassword().equals(entity.getPassword())) {
						return "login successfull";
					}else {
						return "username or password is incorrect";
					}
				}
			}
			return "user doesnot exist";
		}
		else {
			return "dto is null and you entered nothing";
		}
		
	}

}
