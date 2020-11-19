package com.api.carrito.ws.service;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.util.ErrorHandler;
import com.api.carrito.ws.util.ErrorHandlerNotFound;

import java.util.List;


public interface IServiceCliente {

    public ClienteEntity saveCliente (ClienteEntity cliente) throws ErrorHandler;
    public List<ClienteEntity> findAllClientes () throws ErrorHandler;
    
    public ClienteEntity findById(int id) throws ErrorHandler; 	
    
    
}
