package com.api.carrito.ws.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerError {


	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ErrorHandler.class)
	public ResponseEntity<ErrorResponse> mapException2(ErrorHandler error){
	
		ErrorResponse responseError = new ErrorResponse(500,
				"Error en el Servidor",HttpStatus.INTERNAL_SERVER_ERROR.value(),error.getMessage()
				, new Date());
		
		return new ResponseEntity<ErrorResponse>(responseError,HttpStatus.NOT_FOUND);
	}
	
	
}
