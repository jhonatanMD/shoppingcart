package com.api.carrito.ws.controller;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.service.IServiceCliente;
import com.api.carrito.ws.util.ErrorHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiClienteController {

    final  private IServiceCliente serviceCliente;

    public ApiClienteController(IServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente;
    }


    /* Cliente */
    @PostMapping("/saveCliente")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) throws ErrorHandler {


        return serviceCliente.saveCliente(cliente);
    }



    @GetMapping("/findAllCliente")
    public List<ClienteEntity> find() throws ErrorHandler{
        return serviceCliente.findAllClientes();
    }


    @GetMapping("/findByCliente/{id}")
    public ClienteEntity findById(@PathVariable("id") int id ) throws ErrorHandler{
        return serviceCliente.findById(id);
    }

}
