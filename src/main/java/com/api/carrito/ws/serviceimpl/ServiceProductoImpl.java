package com.api.carrito.ws.serviceimpl;

import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.repository.IRepositoryProducto;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.util.ErrorHandler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductoImpl implements IServiceProducto {
	
	static final Logger logProducto = Logger.getLogger("Producto");

    @Autowired
    IRepositoryProducto Iproducto;

    @Override
    public ProductoEntity saveProducto(ProductoEntity producto) throws ErrorHandler{
    	
    	ProductoEntity prod = null;
    	
    	
    	try {
    		
    		prod = Iproducto.save(producto);
    		if(prod == null) {
        		
        		throw new ErrorHandler( "No se pudo guardar producto");
        	}

        	logProducto.info("se guardo producto "+ producto.toString());
    	}catch (Exception e) {
    		
    		logProducto.error("Se produjo el siguiente error : "+e.getMessage());
		}
    
    	
        return prod;
    }

   

    @Override
    public ProductoEntity updProducto(ProductoEntity producto) throws ErrorHandler{
    	ProductoEntity prod = null;
    	
    	
    	try {
    		
    		prod = Iproducto.save(producto);
    		if(prod == null) {

				throw new ErrorHandler( "No se pudo actualizar producto");
        	}

        	logProducto.info("se actualizo producto "+ producto.toString());
    		return prod;
    	}catch (Exception e) {
    		
    		logProducto.error("Se produjo el siguiente error : "+e.getMessage());
    		throw new ErrorHandler("Ocurrio un error en el servidor"+e.getMessage());
		}
    
    	
        
    }

    @Override
    public void deleteProducto(int id) throws ErrorHandler{

    	try {
    		
            Iproducto.deleteById(id);
            logProducto.info("se elimino producto con id : "+ id);
    		
    	}catch (Exception e) {

        	logProducto.error("Ocurrio el siguiente error : "+e.getMessage());
        	throw new ErrorHandler("Ocurrio un error no se pudo eliminar");
		}
    	
    }



	@Override
	public List<ProductoEntity> findAllProdcutos() throws ErrorHandler{
		
	
		try {   	
    		
    		 return Iproducto.findAll();
		}catch (Exception e) {
			
			logProducto.error("Se produjo el siguiente error : "+e.getMessage());
			throw new ErrorHandler("No se pudo listar los productos"+e.getMessage());
		}
    	
    		
       		
    		
    	
    	
    	
       
	}
	
	
}
