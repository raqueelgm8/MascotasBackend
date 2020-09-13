package com.init.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.mascotas.entities.DetallePedido;
import com.init.mascotas.entities.DetallePedidoPK;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoPK> {

}
