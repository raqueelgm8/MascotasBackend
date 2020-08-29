package com.init.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, CrudRepository<Usuario, Integer> {

}
