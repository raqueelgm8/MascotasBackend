package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Solicitud;
import com.init.mascotas.entities.SolicitudPK;

public interface SolicitudRepository extends JpaRepository<Solicitud, SolicitudPK>, CrudRepository<Solicitud, SolicitudPK>{
	
	@Query(value = "SELECT * FROM SOLICITUD u WHERE u.id_usuario = :idUsuario", nativeQuery = true)
	List<Solicitud> solicitudesPorIdUsuario(Integer idUsuario);
}
