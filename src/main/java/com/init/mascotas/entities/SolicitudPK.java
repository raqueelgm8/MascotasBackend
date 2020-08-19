package com.init.mascotas.entities;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the solicitud database table.
 * 
 */
@Embeddable
public class SolicitudPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_SOLICITUD")
	private int idSolicitud;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="ID_ANIMAL", insertable=false, updatable=false)
	private int idAnimal;

	public SolicitudPK() {
	}
	public int getIdSolicitud() {
		return this.idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdAnimal() {
		return this.idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SolicitudPK)) {
			return false;
		}
		SolicitudPK castOther = (SolicitudPK)other;
		return 
			(this.idSolicitud == castOther.idSolicitud)
			&& (this.idUsuario == castOther.idUsuario)
			&& (this.idAnimal == castOther.idAnimal);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSolicitud;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idAnimal;
		
		return hash;
	}
}