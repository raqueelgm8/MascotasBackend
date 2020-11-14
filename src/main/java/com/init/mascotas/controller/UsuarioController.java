package com.init.mascotas.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.entities.Animal;
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
	// Guardar usuario
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarUsuario")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws SerialException, SQLException{
		System.out.println(this.obtenerUltimoId() + 1);
		usuario.setIdUsuario(this.obtenerUltimoId() + 1);
		return usuarioRepository.save(usuario);
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
	// Editar usuario por id
	@PutMapping(value="/editarUsuario/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Usuario editarUsuario(@PathVariable("id") Integer id,@Valid @RequestBody Usuario user) {
		Usuario userUpdate = usuarioRepository.findById(id).get();
	    userUpdate.setNombre(user.getNombre());
	    userUpdate.setApellidos(user.getApellidos());
	    userUpdate.setCodigoPostal(user.getCodigoPostal());
	    userUpdate.setDireccion(user.getDireccion());
	    userUpdate.setDni(user.getDni());
	    userUpdate.setEdad(user.getEdad());
	    userUpdate.setEmail(user.getEmail());
	    userUpdate.setIdUsuario(id);
	    userUpdate.setPassword(user.getPassword());
	    userUpdate.setProvincia(user.getProvincia());
	    userUpdate.setSexo(user.getSexo());
	    userUpdate.setTelefono(user.getTelefono());
	    Usuario userUpdated = usuarioRepository.save(userUpdate);
	    return userUpdated;
	}
}