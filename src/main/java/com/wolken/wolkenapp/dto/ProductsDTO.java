package com.wolken.wolkenapp.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component

public class ProductsDTO {
	
	private int productID;
	
	private String productName;
	
	private String type;
	
	private int price;

}
