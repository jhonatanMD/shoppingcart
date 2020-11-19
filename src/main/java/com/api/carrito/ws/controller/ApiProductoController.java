package com.api.carrito.ws.controller;

import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.util.ErrorHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProductoController {


    final  private IServiceProducto serviceProducto;

    public ApiProductoController(IServiceProducto serviceProducto) {
        this.serviceProducto = serviceProducto;
    }

    /* Producto */
    @PostMapping("/saveProducto")
    public ProductoEntity saveProducto(@RequestBody ProductoEntity producto) throws ErrorHandler {

        return serviceProducto.saveProducto(producto);
    }

    @GetMapping("/findAllProducto")
    public List<ProductoEntity> findAllProductos() throws ErrorHandler {

        return serviceProducto.findAllProdcutos();
    }

    @PostMapping("/updProducto/{idProd}")
    public ProductoEntity updProducto(@PathVariable("idProd") int idProd ,@RequestBody ProductoEntity producto) throws ErrorHandler{
        producto.setIdProducto(idProd);
        return serviceProducto.updProducto(producto);
    }

    @PostMapping("/dltProducto/{idProd}")
    public void dltProducto(@PathVariable("idProd") int idProd ) throws ErrorHandler{
        serviceProducto.deleteProducto(idProd);
    }
}
