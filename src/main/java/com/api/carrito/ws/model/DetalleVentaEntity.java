package com.api.carrito.ws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DetalleVenta")
public class DetalleVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDetalleVenta;


    private int idVenta;

  
    private int idProducto;


	@Override
	public String toString() {
		return "DetalleVentaEntity [idDetalleVenta=" + idDetalleVenta + ", idVenta=" + idVenta + ", idProducto="
				+ idProducto + "]";
	}
    
    
}
