package com.api.carrito.ws.repository;

import com.api.carrito.ws.model.DetalleVentaEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryDetalleVenta  extends JpaRepository<DetalleVentaEntity,Integer> {
	
	Optional<DetalleVentaEntity> findByIdVenta(int id) ;
}
