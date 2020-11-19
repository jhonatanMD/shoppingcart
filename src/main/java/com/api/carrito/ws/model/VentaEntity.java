package com.api.carrito.ws.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Venta")
public class VentaEntity {
	
	public VentaEntity(int idCliente , Date fecha ) {
		
		this.fecha = fecha;
		this.idCliente = idCliente;
		
	}
	


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVenta;

    private int idCliente;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull
    private Date fecha;

	@Override
	public String toString() {
		return "VentaEntity [idVenta=" + idVenta + ", idCliente=" + idCliente + ", fecha=" + fecha + "]";
	}
    
    
}
