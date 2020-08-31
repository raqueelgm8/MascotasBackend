package com.init.mascotas.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the solicitud database table.
 * 
 */

@Entity
@Table(name="solicitud")
@NamedQuery(name="Solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SolicitudPK id;

	private String estado;

	private String horariotrabajo;

	private byte jardin;

	private byte mascotascasa;

	private String miembrosfamilia;

	@Column(name="RAZON_ADOPCION")
	private String razonAdopcion;

	private byte terraza;

	//bi-directional many-to-one association to Animal
	/*@ManyToOne
	@JoinColumn(name="ID_ANIMAL", insertable = false, updatable = false)
	private Animal animal;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", insertable = false, updatable = false)
	private Usuario usuario;*/

	public Solicitud() {
	}

	public SolicitudPK getId() {
		return this.id;
	}

	public void setId(SolicitudPK id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHorariotrabajo() {
		return this.horariotrabajo;
	}

	public void setHorariotrabajo(String horariotrabajo) {
		this.horariotrabajo = horariotrabajo;
	}

	public byte getJardin() {
		return this.jardin;
	}

	public void setJardin(byte jardin) {
		this.jardin = jardin;
	}

	public byte getMascotascasa() {
		return this.mascotascasa;
	}

	public void setMascotascasa(byte mascotascasa) {
		this.mascotascasa = mascotascasa;
	}

	public String getMiembrosfamilia() {
		return this.miembrosfamilia;
	}

	public void setMiembrosfamilia(String miembrosfamilia) {
		this.miembrosfamilia = miembrosfamilia;
	}

	public String getRazonAdopcion() {
		return this.razonAdopcion;
	}

	public void setRazonAdopcion(String razonAdopcion) {
		this.razonAdopcion = razonAdopcion;
	}

	public byte getTerraza() {
		return this.terraza;
	}

	public void setTerraza(byte terraza) {
		this.terraza = terraza;
	}

	/*public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/

}