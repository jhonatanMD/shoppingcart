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
@Table(name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;

    private String nombre;

    private long precio;

	@Override
	public String toString() {
		return "ProductoEntity [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
    
    
}
