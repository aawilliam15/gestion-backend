package com.gestion.reclamo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "user", length = 100, nullable = false)
	private String user;
	
	@Column(name = "pwd", length = 100, nullable = false)	
	private String pwd;
	
	@Column(name = "token", length = 800, nullable = false)
	private String token;	
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPwd() {
		return pwd;
	}




	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}




	public User(String user, String pwd, String token) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.token = token;
	}
	
	
	public User() {	
	}
	
}
