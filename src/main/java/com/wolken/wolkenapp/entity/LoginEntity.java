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
@Table(name = "login_table")
public class LoginEntity {
	@Id
	@Column(name = "userName")
	private String userName;
	@Column(name = "password")
	private String password;
	

}
