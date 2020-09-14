package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Pedido;
import com.init.mascotas.entities.PedidoPK;

public interface PedidoRepository extends JpaRepository<Pedido, PedidoPK>, CrudRepository<Pedido, PedidoPK>{

	@Query(value = "SELECT * FROM PEDIDO p WHERE p.id_usuario = :idUsuario", nativeQuery = true)
	List<Pedido> findPedidosUsuario(Integer idUsuario);
	
	@Query(value= "SELECT max(ID_PEDIDO) FROM PEDIDO", nativeQuery = true)
	Integer obtenerUltimoIdPedido();
}
