package com.api.carrito.ws.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoDetalleVenta {

    private int idDetalleVenta ;
    private int idVenta;
    private String Cliente;
    private int dni;
    private String email;
    private Date fechaCompra;
    private String producto;
    private long precioProducto;
    
    
	@Override
	public String toString() {
		return "DtoDetalleVenta [idDetalleVenta=" + idDetalleVenta + ", idVenta=" + idVenta + ", Cliente=" + Cliente
				+ ", dni=" + dni + ", email=" + email + ", fechaCompra=" + fechaCompra + ", producto=" + producto
				+ ", precioProducto=" + precioProducto + "]";
	}
    
    

}
