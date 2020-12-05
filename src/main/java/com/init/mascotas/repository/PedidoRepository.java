package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.init.mascotas.entities.Pedido;
import org.springframework.transaction.annotation.Transactional;
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query(value = "SELECT * FROM PEDIDO p WHERE p.id_usuario = :idUsuario", nativeQuery = true)
	List<Pedido> findPedidosUsuario(Integer idUsuario);
	
	@Query(value= "SELECT max(ID_PEDIDO) FROM PEDIDO", nativeQuery = true)
	Integer obtenerUltimoIdPedido();
	
	@Modifying
	@Query(value = "UPDATE PEDIDO SET ESTADOPEDIDO=:estado WHERE id_pedido =:idPedido", nativeQuery = true)
	@Transactional(rollbackFor=Exception.class)
	void updateEstado(Integer idPedido, String estado);
}
