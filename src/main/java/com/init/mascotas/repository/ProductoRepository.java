package com.init.mascotas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Animal;
import com.init.mascotas.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query(value = "SELECT * FROM PRODUCTO p WHERE (:categoria is null or p.categoria LIKE :categoria)"
			+ "AND (:tipoAnimal is null or p.TIPOANIMAL LIKE :tipoAnimal) "
			+ "ORDER BY p.tipoAnimal", nativeQuery = true)
	List<Producto> findProductoFiltrado(String categoria, String tipoAnimal);
	
	@Query(value= "SELECT max(ID_PRODUCTO) FROM PRODUCTO", nativeQuery = true)
	Integer obtenerUltimoIdPedido();
}
