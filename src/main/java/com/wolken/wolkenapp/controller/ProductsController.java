package com.wolken.wolkenapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wolken.wolkenapp.dto.ProductsDTO;
import com.wolken.wolkenapp.entity.ProductsEntity;
import com.wolken.wolkenapp.service.ProductsService;

@Controller
@RequestMapping("/")
public class ProductsController {
	
	@Autowired
	ProductsService service;
	@Autowired
	ProductsEntity entity;
	@RequestMapping("/addproducts.do")
	public String addProducts(@ModelAttribute ProductsDTO dto,HttpServletRequest request) {
		String message = null;
		message = service.validateAndAdd(dto);
		request.setAttribute("message", message);
		return "addProductsResponse.jsp";

}
	@RequestMapping("/getproductbytype.do")
	public String getProductByType(@RequestParam(name = "type")String type , HttpServletRequest request) {
		List<ProductsEntity> entityList = service.validateAndGetProductByType(type);
		request.setAttribute("entityList", entityList);
		return "getProductByTypeResponse.jsp";
	}
	
	
}