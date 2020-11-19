package com.api.carrito.ws.controller;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.service.IServiceCliente;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.util.ErrorHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiClienteControllerTest {

    @InjectMocks
    ApiClienteController apiClienteController;

    @Mock
    IServiceCliente iServiceCliente;

    @Test
    public void testControllerSaveCliente() throws ErrorHandler {

        ClienteEntity cliente =
                new ClienteEntity(1,"jhonatan","mallqui",8767899,98876534,"jmallqui@gmail.com");

        when(iServiceCliente.saveCliente(cliente)).thenReturn(cliente);
        assertEquals(apiClienteController.saveCliente(cliente),cliente);

    }

    @Test
    public void testControllerFindAllCliente() throws ErrorHandler {

        List<ClienteEntity> clientes =
                Arrays.asList( new ClienteEntity(1,"jhonatan","mallqui",8767899,98876534,"jmallqui@gmail.com"));
        when(iServiceCliente.findAllClientes()).thenReturn(clientes);
        assertEquals(apiClienteController.find(),clientes);

    }





}
