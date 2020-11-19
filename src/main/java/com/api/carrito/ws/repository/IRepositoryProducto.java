package com.api.carrito.ws.repository;

import com.api.carrito.ws.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProducto extends JpaRepository<ProductoEntity,Integer> {
}
