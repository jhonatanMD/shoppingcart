package com.api.carrito.ws.controller;

import com.api.carrito.ws.model.DetalleVentaEntity;
import com.api.carrito.ws.model.DtoDetalleVenta;
import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.service.IServiceDetalleVenta;
import com.api.carrito.ws.service.IServiceVenta;
import com.api.carrito.ws.util.ErrorHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiVentaController {

    final private IServiceDetalleVenta serviceDetalleVenta;
    final private IServiceVenta serviceVenta;

    public ApiVentaController(IServiceDetalleVenta serviceDetalleVenta, IServiceVenta serviceVenta) {
        this.serviceDetalleVenta = serviceDetalleVenta;
        this.serviceVenta = serviceVenta;
    }
    /* Detalle de Venta */


    @PostMapping("/saveVenta")
    public VentaEntity saveVenta (@RequestBody VentaEntity venta)  throws ErrorHandler {

        venta.setFecha(new Date());

        return serviceVenta.saveVenta(venta);
    }

    @GetMapping("/findAllVenta")
    public List<VentaEntity> findAllVenta () throws ErrorHandler{

        return serviceVenta.findAll();
    }

    @GetMapping("/getDetalleVenta/{idVenta}")
    public DtoDetalleVenta getDetalleVenta(@PathVariable("idVenta") int idVenta) throws ErrorHandler{

        return  serviceDetalleVenta.findDetalleVenta(idVenta);
    }

    @PostMapping("/saveDetalleVenta")
    public DetalleVentaEntity saveDetalleVetan(@RequestBody DetalleVentaEntity detalle ) throws ErrorHandler{
        return serviceDetalleVenta.saveDetalleVeta(detalle);
    }

}
