package com.api.carrito.ws.repository;

import com.api.carrito.ws.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCliente extends JpaRepository<ClienteEntity,Integer> {
}
