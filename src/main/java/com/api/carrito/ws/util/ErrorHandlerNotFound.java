package com.api.carrito.ws.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorHandlerNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public ErrorHandlerNotFound(String message) {
		super(message);
	}
	
	
	

}
