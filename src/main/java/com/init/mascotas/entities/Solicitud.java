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

	/*@EmbeddedId
	private SolicitudPK id;*/
	
	@Id
	@Column(name="ID_SOLICITUD")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSolicitud;
	
	@Column(name="ID_ANIMAL")
	private Integer idAnimal;
	
	@Column(name="ID_USUARIO")
	private Integer idUsuario;
	
	@Column(name="ESTADO")
	private String estado;

	@Column(name="HORARIOTRABAJO")
	private String horarioTrabajo;

	@Column(name="JARDIN")
	private byte jardin;

	@Column(name="MASCOTASCASA")
	private byte mascotascasa;

	@Column(name="MIEMBROSFAMILIA")
	private String miembrosfamilia;

	@Column(name="RAZONADOPCION")
	private String razonAdopcion;

	@Column(name="NOMBREANIMAL", updatable = false)
	private String nombreAnimal;
	
	@Column(name="TIPOANIMAL", updatable = false)
	private String tipoAnimal;
	
	@Column(name="TERRAZA")
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

	public String getNombreAnimal() {
		return nombreAnimal;
	}

	public void setNombreAnimal(String nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getHorarioTrabajo() {
		return horarioTrabajo;
	}

	public void setHorarioTrabajo(String horarioTrabajo) {
		this.horarioTrabajo = horarioTrabajo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHorariotrabajo() {
		return this.horarioTrabajo;
	}

	public void setHorariotrabajo(String horariotrabajo) {
		this.horarioTrabajo = horariotrabajo;
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