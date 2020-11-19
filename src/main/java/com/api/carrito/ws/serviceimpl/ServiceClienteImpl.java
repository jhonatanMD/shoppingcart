package com.api.carrito.ws.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.repository.IRepositoryCliente;
import com.api.carrito.ws.service.IServiceCliente;
import com.api.carrito.ws.util.ErrorHandler;

@Service
public class ServiceClienteImpl implements IServiceCliente {


    static final Logger logCliente = Logger.getLogger("Cliente");
    
    @Autowired
    IRepositoryCliente Icliente;

    @Override
    public ClienteEntity saveCliente(ClienteEntity cliente) throws ErrorHandler{

    	ClienteEntity clienter = null;
    	
    	try {
    		
    		clienter = Icliente.save(cliente);
    		
    		if(clienter == null)
    		{
    			throw new ErrorHandler("Hubo un problema al registrar al cliente");
    		}
    		
    		logCliente.info("Se guardo cliente" + cliente.toString());

    		return clienter;
    	}
    	catch(Exception e) {
    		
    		logCliente.error("Se Presento el siguiente error : " + e.getMessage());
    		throw new ErrorHandler("Error : "+e.getMessage());
    	}
    	
    	
    	
    }

    @Override
    public List<ClienteEntity> findAllClientes() throws ErrorHandler{

    	try {
    		
    		logCliente.info("Se listo clientes " + Icliente.findAll());
    		return Icliente.findAll();
    	}catch (Exception e) {
    		
    		logCliente.error("Se presento el siguiente error" + e.getMessage());
    		throw new ErrorHandler("Hubo un problema al listar los Clientes"+e.getMessage());
		}
    	
        
    }

	@Override
	public ClienteEntity findById(int id) throws  ErrorHandler {
		
		
		ClienteEntity cliente = null;
		
		
		try {
			
			cliente = Icliente.findAll()
					.stream().filter( x -> x.getId() == id)
					.collect(Collectors.toList()).get(0);
			logCliente.info("Se filtro cliente por id: " + id);
		
			
			return cliente;
			
		}catch (Exception e) {
			logCliente.error("No se encontro cliente con el id "+ id +" status : "+HttpStatus.INTERNAL_SERVER_ERROR.value());
			throw new ErrorHandler("No se encontro cliente con el id "+ id +" status : "+HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		

		
	}
}
