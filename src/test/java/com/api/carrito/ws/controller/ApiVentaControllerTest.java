package com.api.carrito.ws.controller;

import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.service.IServiceVenta;
import com.api.carrito.ws.util.ErrorHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiVentaControllerTest {

    @InjectMocks
    ApiVentaController apiVentaController;

    @Mock
    IServiceVenta serviceVenta;


    @Test(expected = AssertionError.class)
    public void testControllerFindAllProductError() throws ErrorHandler {

     List<VentaEntity> ventas = Arrays.asList(new VentaEntity(1,2,new Date()));

     when(serviceVenta.findAll()).thenReturn(ventas);
     assertEquals(apiVentaController.findAllVenta(),null);

    }
}
