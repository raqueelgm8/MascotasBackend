package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.init.mascotas.entities.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{
	
	@Query(value = "SELECT * FROM SOLICITUD u WHERE u.id_usuario = :idUsuario", nativeQuery = true)
	List<Solicitud> solicitudesPorIdUsuario(Integer idUsuario);
	
	@Query(value= "SELECT max(ID_SOLICITUD) FROM SOLICITUD", nativeQuery = true)
	Integer obtenerUltimoId();
	
	@Query(value = "SELECT * FROM SOLICITUD u WHERE u.id_animal = :idAnimal", nativeQuery = true)
	List<Solicitud> solicitudesPorAnimal(Integer idAnimal);
	
	@Modifying
	@Query(value = "UPDATE SOLICITUD SET ESTADO=:estado WHERE id_solicitud =:idSolicitud", nativeQuery = true)
	@Transactional(rollbackFor=Exception.class)
	void updateEstadoSolicitud(Integer idSolicitud, String estado);
	
	@Modifying
	@Query(value = "UPDATE SOLICITUD SET ESTADO=:estado WHERE id_solicitud !=:idSolicitud AND ID_ANIMAL =:idAnimal", nativeQuery = true)
	@Transactional(rollbackFor=Exception.class)
	void updateEstadoSolicitudDenegado(Integer idSolicitud, Integer idAnimal, String estado);
}
