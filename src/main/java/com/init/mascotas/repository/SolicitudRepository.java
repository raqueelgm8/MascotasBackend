package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.init.mascotas.entities.Solicitud;
import com.init.mascotas.entities.SolicitudPK;

public interface SolicitudRepository extends JpaRepository<Solicitud, SolicitudPK>, CrudRepository<Solicitud, SolicitudPK>{
	
	@Query(value = "SELECT * FROM SOLICITUD u WHERE u.id_usuario = :idUsuario", nativeQuery = true)
	List<Solicitud> solicitudesPorIdUsuario(Integer idUsuario);
	
	@Query(value= "SELECT max(ID_SOLICITUD) FROM SOLICITUD", nativeQuery = true)
	Integer obtenerUltimoId();
	
	@Modifying
	@Query(value = "UPDATE SOLICITUD SET ESTADO=:estado WHERE id_usuario = :idUsuario AND id_Animal =:idAnimal AND id_solicitud =:idSolicitud", nativeQuery = true)
	@Transactional(rollbackFor=Exception.class)
	void updateEstadoSolicitud(Integer idUsuario, Integer idAnimal, Integer idSolicitud, String estado);
}
