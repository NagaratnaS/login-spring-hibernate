package com.wolken.wolkenapp.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.LoginDTO;
import com.wolken.wolkenapp.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	LoginService service;
	@Autowired
	LoginDTO dto;
	@SuppressWarnings("finally")
	@RequestMapping("/login.do")
	public String save(@ModelAttribute LoginDTO dto , HttpServletRequest request) {
		String message = null;
		System.out.print(dto.getUserName()+" "+dto.getPassword());
		try {
			message = service.validateAndLogin(dto);
			
		} catch (SessionException | TransactionException e) {
			// TODO Auto-generated catch block
			message = "SOME ERROR OCCURRED!!";
			e.printStackTrace();
		} finally {
			request.setAttribute("message", message);
			return "final.jsp";
		}
		
		
	}

}
