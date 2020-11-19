package com.api.carrito.ws.repository;

import com.api.carrito.ws.model.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryVenta extends JpaRepository<VentaEntity,Integer> {
}
