package com.api.carrito.ws.controller;

import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.util.ErrorHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.parameters.P;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ApiProductoControllerTest {

    @InjectMocks
    ApiProductoController productoController;

    @Mock
    IServiceProducto serviceProducto;

    @Test
    public void testControllerSaveProduct() throws ErrorHandler {

        ProductoEntity producto = new ProductoEntity(1,"Coca-Cola",10);

        when(serviceProducto.saveProducto(producto)).thenReturn(producto);
        assertEquals(productoController.saveProducto(producto),producto);

    }

    @Test
    public void testControllerFindAllProduct() throws ErrorHandler {

        List<ProductoEntity> productos = Arrays.asList(new ProductoEntity(1,"Coca-Cola",10)
        ,new ProductoEntity(2,"Pepsi",11));

        when(serviceProducto.findAllProdcutos()).thenReturn(productos);
        assertEquals(productoController.findAllProductos(),productos);

    }


    @Test(expected = AssertionError.class)
    public void testControllerFindAllProductError() throws ErrorHandler {

        List<ProductoEntity> productos = Arrays.asList(new ProductoEntity(1,"Coca-Cola",10)
                ,new ProductoEntity(2,"Pepsi",11));

        when(serviceProducto.findAllProdcutos()).thenReturn(productos);

        assertEquals(productoController.findAllProductos(),null);


    }
}
