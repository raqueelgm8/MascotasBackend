package com.init.mascotas.entities;

import java.util.Arrays;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@Entity
@Table(name="animal")
public class Animal {
	@Id
	@Column(name="ID_ANIMAL")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnimal;
	@Column(name="ADOPTADO")
	private boolean adoptado;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="EDAD")
	private int edad;
	@Column(name="IMAGEN")
	@Lob
	private byte[] imagen;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="RAZA")
	private String raza;
	@Column(name="TIPOANIMAL")
	private String tipoAnimal;
	@Column(name="TIPOEDAD")
	private String tipoedad;
	@Column(name="SEXO")
	private String sexo;
	//bi-directional many-to-one association to Solicitud
	// @OneToMany(mappedBy="animal")
	// private List<Solicitud> solicituds;
	
	public Animal() {
		super();
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public boolean getAdoptado() {
		return adoptado;
	}

	public void setAdoptado(boolean adoptado) {
		this.adoptado = adoptado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getTipoedad() {
		return tipoedad;
	}

	public void setTipoedad(String tipoedad) {
		this.tipoedad = tipoedad;
	}

	@Override
	public String toString() {
		return "Animal [idAnimal=" + idAnimal + ", adoptado=" + adoptado + ", descripcion=" + descripcion + ", edad="
				+ edad + ", imagen=" + Arrays.toString(imagen) + ", nombre=" + nombre + ", raza=" + raza
				+ ", tipoAnimal=" + tipoAnimal + ", tipoedad=" + tipoedad + "]";
	}
}
