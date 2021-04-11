package com.wolken.wolkenapp.dao;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.entity.LoginEntity;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;

public interface LoginDAO {
	public LoginEntity add(String userName) throws SessionException, TransactionException;

}
