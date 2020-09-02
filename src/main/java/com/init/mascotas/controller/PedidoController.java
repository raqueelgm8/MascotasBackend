package com.init.mascotas.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Pedido;
import com.init.mascotas.entities.PedidoPK;

public interface PedidoController extends JpaRepository<Pedido, PedidoPK>, CrudRepository<Pedido, PedidoPK>{

}
