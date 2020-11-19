package com.api.carrito.ws.service;

import com.api.carrito.ws.model.DetalleVentaEntity;
import com.api.carrito.ws.model.DtoDetalleVenta;
import com.api.carrito.ws.util.ErrorHandler;

public interface IServiceDetalleVenta {

    public DtoDetalleVenta findDetalleVenta(int idVenta) throws ErrorHandler;
    
    public DetalleVentaEntity saveDetalleVeta(DetalleVentaEntity detalle) throws ErrorHandler;

}
