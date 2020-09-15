package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.mascotas.entities.DetallePedido;
import com.init.mascotas.entities.DetallePedidoPK;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoPK> {
	@Query(value = "SELECT * FROM DETALLE_PEDIDO p WHERE p.id_usuario = :idUsuario "
			+ "AND p.id_pedido = :idPedido", nativeQuery = true)
	List<DetallePedido> findDetallesPorPedido(Integer idUsuario, Integer idPedido);
}
