package com.api.carrito.ws.serviceimpl;

import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.repository.IRepositoryVenta;
import com.api.carrito.ws.service.IServiceVenta;
import com.api.carrito.ws.util.ErrorHandler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVentaImpl implements IServiceVenta {

	
	 static final Logger logVenta = Logger.getLogger("Venta");
	 
    @Autowired
    IRepositoryVenta Iventa;

    @Override
    public VentaEntity saveVenta(VentaEntity venta) throws ErrorHandler {
    	
    	VentaEntity ventaE= null;
    	
    	try {
    		
    		ventaE = Iventa.save(venta);
    		
    		if(ventaE == null) {
    			
    			throw new  ErrorHandler( "Ocurrio un error al registrar la venta");
    		}

        	logVenta.info("Se guardo Venta "+ venta.toString());
    		
    	}catch (Exception e) {
			logVenta.error("Se produjo el error de  : " +e.getMessage()) ;
			throw new  ErrorHandler( e.getMessage());
		}
    	
        return ventaE;
    }

    @Override
    public List<VentaEntity> findAll()  throws ErrorHandler{
    
    	try {
    		
    		logVenta.info("Lista de ventas "+ Iventa.findAll());
    		
       	 	return Iventa.findAll();
    	}catch (Exception e) {
    		logVenta.error("Se produjo el error de : "+ e.getMessage());
    		throw new ErrorHandler( e.getMessage());
    		
		}

    	
    }
}
