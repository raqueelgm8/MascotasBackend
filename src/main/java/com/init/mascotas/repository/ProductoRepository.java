package com.init.mascotas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>, CrudRepository<Producto, Integer>{

}
