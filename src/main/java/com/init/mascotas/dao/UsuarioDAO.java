package com.init.mascotas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Usuario;

public interface UsuarioDAO  extends JpaRepository<Usuario, Integer>, CrudRepository<Usuario, Integer>{
	// public List<Usuario> findByEmailAndPassword(String email, String password);
}
