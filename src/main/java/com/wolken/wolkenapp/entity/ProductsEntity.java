package com.wolken.wolkenapp.entity;

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
@Entity
@Table(name = "products")
public class ProductsEntity {
	@Id
	@Column(name = "productID")
	private int productID;
	@Column(name = "productName")
	private String productName;
	@Column(name = "type")
	private String type;
	@Column(name = "price")
	private int price;

}
