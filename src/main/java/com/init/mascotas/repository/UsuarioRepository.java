package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, CrudRepository<Usuario, Integer> {

	@Query(value = "SELECT * FROM USUARIO u WHERE u.email LIKE :email AND "
			+ "u.password LIKE :pass ORDER BY u.email", nativeQuery = true)
	List<Usuario> usuarioPorEmailPass(String email, String pass);
	
	@Query(value = "INSERT INTO USUARIO(nombre, apellidos, email, password, sexo, dni,"
			+ "edad, direccion, provincia, codigopostal, telefono)" + 
			"VALUES(:nombre, :apellidos, :email, :pass, :sexo, :dni, :edad, :direccion, :provincia, :codigoPostal, :telefono)", 
			nativeQuery = true)
	Usuario crearUsuario(String nombre, String apellidos, String email, String pass,
						String sexo, String dni, int edad, String direccion, String provincia,
						String codigoPostal, String telefono);
	
	@Query(value= "SELECT max(ID_USUARIO) FROM USUARIO", nativeQuery = true)
	Integer obtenerUltimoId();
	
	/*@Modifying
	@Query(value="UPDATE Usuario user" + 
			" SET nombre = :user.nombre, apellidos= :user.apellidos, email= :user.email, password = :user.password, sexo = :user.sexo,"
			+ " dni = :user.dni, edad = user.edad, direccion = :user.direccion, provincia = :user.provincia, codigoPostal = user.codigoPostal,"
			+ " telefono = :user.telefono, id_usuario = :id" + 
			" WHERE id_usuario = :id;",nativeQuery = true)
	Usuario editarUsuario(Integer id, Usuario user);*/
}
