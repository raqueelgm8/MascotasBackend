package com.init.mascotas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.dao.UsuarioDAO;
import com.init.mascotas.entities.Usuario;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioREST {
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	// Devuelve todos los usuarios
	@RequestMapping(value="usuarios", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> usuarios = usuarioDAO.findAll();
		return ResponseEntity.ok(usuarios);
	}
	// Devuelve usuario por su id
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> getComboById(@PathVariable("id") Integer id) {
		Optional<Usuario> optionalUsuario = usuarioDAO.findById(id);
		if (optionalUsuario.isPresent()) {
			return ResponseEntity.ok(optionalUsuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
