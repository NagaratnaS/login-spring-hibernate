package com.wolken.wolkenapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wolken.wolkenapp.Exceptions.DTONullException;
import com.wolken.wolkenapp.Exceptions.InvalidInputException;
import com.wolken.wolkenapp.Exceptions.SessionException;
import com.wolken.wolkenapp.Exceptions.TransactionException;
import com.wolken.wolkenapp.dto.RegistrationDTO;
import com.wolken.wolkenapp.entity.RegistartionEntity;
import com.wolken.wolkenapp.service.RegistrationService;

@Controller
@RequestMapping("/")
public class RegistrationController {
	
	
	@Autowired
	RegistrationService service;
	@Autowired
	RegistartionEntity entity;
	@RequestMapping("/register.do")
	public String save(@ModelAttribute RegistrationDTO dto , HttpServletRequest request) {
		String message = null;
		System.out.println(dto.getContact_number());
		try {
			message = service.validateAndAdd(dto);
		} catch (DTONullException | InvalidInputException | TransactionException | SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message",message);
		
		return "final.jsp";
		
	}
	
	@RequestMapping("/update.do")
	public String UpdateByEmailID(@ModelAttribute RegistrationDTO dto , HttpServletRequest request) {
		String message = null;
		message = service.validateAndUpdateByEmailID(dto);
		
		request.setAttribute("message", message);
		
		return "final.jsp";
		
	}
	
	@RequestMapping("/getUserByUserName.do")
	public String getUserByUserName(@RequestParam(name="userName")String userName, HttpServletRequest request) {
		entity = service.validateAndGetUserByUserName(userName);
		
		request.setAttribute("userName", entity.getUserName());
		request.setAttribute("contactNumber", entity.getContact_number()); // ${contactNumber}
		request.setAttribute("dob", entity.getDateOfBirth()); // ${dob}
		request.setAttribute("emailid", entity.getEmailID());  // ${emailid}
		request.setAttribute("gender", entity.getGender());

		return "getUserByUserNameResponse.jsp";
		
	}
	

}
