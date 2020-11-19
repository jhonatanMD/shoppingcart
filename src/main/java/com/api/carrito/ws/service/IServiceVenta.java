package com.api.carrito.ws.service;

import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.util.ErrorHandler;

import java.util.List;

public interface IServiceVenta {

    public VentaEntity saveVenta(VentaEntity venta) throws ErrorHandler;

    public List<VentaEntity> findAll() throws ErrorHandler;

}
