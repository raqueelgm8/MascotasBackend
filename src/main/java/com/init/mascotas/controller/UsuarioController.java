package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.init.mascotas.entities.Usuario;
import com.init.mascotas.repository.UsuarioRepository;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// Devuelve todos los usuarios
	@RequestMapping(value="usuarios", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return ResponseEntity.ok(usuarios);
	}
	// Devuelve usuario por su id
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> getComboById(@PathVariable("id") Integer id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			return ResponseEntity.ok(optionalUsuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}