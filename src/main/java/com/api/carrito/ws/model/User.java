package com.api.carrito.ws.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	
	public User() {}
	
	public User (String user , String pwd) {
		
		this.user = user;
		this.pwd = pwd;
				
	}
	

	private String user;
	private String pwd;
	private String token;


}
