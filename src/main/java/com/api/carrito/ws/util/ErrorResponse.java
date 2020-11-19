package com.api.carrito.ws.util;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private int HttpStatus;
	private String Message;
	private int Code;
	private String BackMessage;
	private Date date;
}
