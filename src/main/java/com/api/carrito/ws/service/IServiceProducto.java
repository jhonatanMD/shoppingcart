package com.api.carrito.ws.service;

import java.util.List;

import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.util.ErrorHandler;

public interface IServiceProducto {

    public ProductoEntity saveProducto(ProductoEntity producto) throws ErrorHandler;
    public List<ProductoEntity> findAllProdcutos() throws ErrorHandler;
    public ProductoEntity updProducto(ProductoEntity producto) throws ErrorHandler;
    public void deleteProducto(int id) throws ErrorHandler;

}
