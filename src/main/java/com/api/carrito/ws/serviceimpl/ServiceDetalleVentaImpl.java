package com.api.carrito.ws.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.model.DetalleVentaEntity;
import com.api.carrito.ws.model.DtoDetalleVenta;
import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.repository.IRepositoryCliente;
import com.api.carrito.ws.repository.IRepositoryDetalleVenta;
import com.api.carrito.ws.repository.IRepositoryProducto;
import com.api.carrito.ws.repository.IRepositoryVenta;
import com.api.carrito.ws.service.IServiceDetalleVenta;
import com.api.carrito.ws.util.ErrorHandler;

@Service
public class ServiceDetalleVentaImpl implements IServiceDetalleVenta {


    static final Logger logDetalleVenta = Logger.getLogger("Detalle");

    @Autowired
    IRepositoryProducto productos;

    @Autowired
    IRepositoryVenta ventas;

    @Autowired
    IRepositoryCliente clientes;

    @Autowired
    IRepositoryDetalleVenta detalleVentaRepository;


    public DtoDetalleVenta findDetalleVenta(int idVenta) throws ErrorHandler{
    	
        DtoDetalleVenta dto = new DtoDetalleVenta();
    	
    	try {
	    	ClienteEntity cliente ;
	    	ProductoEntity producto;
	    	DetalleVentaEntity detalle;
	    	
	    	
	    	VentaEntity venta = ventas.findById(idVenta).get();
	    	cliente = clientes.findById(venta.getIdCliente()).get();
	    	detalle = detalleVentaRepository.findByIdVenta(venta.getIdVenta()).get();
	    	producto = productos.findById(detalle.getIdProducto()).get();
	    
	        
	        dto.setIdDetalleVenta(detalle.getIdDetalleVenta());
	        dto.setIdVenta(idVenta);
	        dto.setCliente(cliente.getNombre() + " " + cliente.getApellido());
	        dto.setDni(cliente.getDni());
	        dto.setEmail(cliente.getEmail());
	        dto.setPrecioProducto(producto.getPrecio());
	        dto.setFechaCompra(venta.getFecha());
	        dto.setProducto(producto.getNombre());
	        logDetalleVenta.info("Se muestra DTO " +dto.toString());
	    
	        return dto;
    	}catch (Exception e) {
    		
    		logDetalleVenta.error("Se presento el siguiente error : "+e.getMessage());
    		throw new ErrorHandler("Error al listar los detalles"+e.getMessage());
		}
        
    }


	@Override
	public DetalleVentaEntity saveDetalleVeta(DetalleVentaEntity detalle) throws ErrorHandler{
			DetalleVentaEntity detallev = null;
		
		try {
			
			 detallev = detalleVentaRepository.save(detalle);
			
			if(detallev == null) {
				
				throw new ErrorHandler( "No se registro correctamente el detalle");
			}
				
			logDetalleVenta.info("Se guarda Detalle de Venta " +detalle.toString());

			return detallev;
			
		}catch (Exception e) {
			
			logDetalleVenta.error("Se produjo el siguiente error : "+e.getMessage());
			throw new ErrorHandler( "Ocurrio un error : r"+e.getMessage());
		}
		
		
	}
}
