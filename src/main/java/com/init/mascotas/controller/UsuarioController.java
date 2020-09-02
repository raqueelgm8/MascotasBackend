package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Usuario> getUusarioById(@PathVariable("id") Integer id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			return ResponseEntity.ok(optionalUsuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// Devuelve una lista de usuarios en los que coincida el email y su contraseña
	@GetMapping("/getUsuarios/{email}/{pass}")
    public List<Usuario> usuarioPorEmailPass(@PathVariable(value="email") String email, @PathVariable(value="pass") String pass){
        return usuarioRepository.usuarioPorEmailPass(email, pass);
    }
	// Crea un usuario
	@GetMapping("/crearUsuario/{nombre}/{apellidos}/{email}/{pass}/{sexo}/{dni}/{edad}/{direccion}/{provincia}/{codigoPostal}/{telefono}")
	Usuario crearUsuario(
			@PathVariable(value="nombre") String nombre,
			@PathVariable(value="apellidos") String apellidos, 
			@PathVariable(value="email") String email,
			@PathVariable(value="pass") String pass,
			@PathVariable(value="sexo") String sexo,
			@PathVariable(value="dni") String dni, 
			@PathVariable(value="edad") int edad,
			@PathVariable(value="direccion") String direccion,
			@PathVariable(value="provincia")String provincia,
			@PathVariable(value="codigoPostal") String codigoPostal,
			@PathVariable(value="telefono")String telefono) {
		
		Usuario user =  new Usuario();
		user.setIdUsuario(this.obtenerUltimoId() + 1);
		user.setApellidos(apellidos);
		user.setNombre(nombre);
		user.setEmail(email);
		user.setPassword(pass);
		user.setSexo(sexo);
		user.setDni(dni);
		user.setEdad(edad);
		user.setDireccion(direccion);
		user.setProvincia(provincia);
		user.setCodigoPostal(codigoPostal);
		user.setTelefono(telefono);
		return usuarioRepository.save(user);
		// return (Usuario) usuarioRepository.crearUsuario(nombre, apellidos, email, pass, sexo, dni, edad, direccion, provincia, codigoPostal, telefono);
	}
	// Último id
	@GetMapping("/ultimoId")
	public int obtenerUltimoId() {
		return usuarioRepository.obtenerUltimoId();
	}
	// Eliminar usuario por id
	@DeleteMapping(value="/eliminarUsuario/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminarUsuario(@PathVariable("id") Integer id) {
		this.usuarioRepository.deleteById(id);
	}
}