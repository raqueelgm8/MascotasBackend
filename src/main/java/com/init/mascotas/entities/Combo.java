package com.init.mascotas.entities;
import javax.persistence.*;

@Entity
@Table(name="combo")
public class Combo {
	@Id
	@Column(name="ID")
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column(name="TIPO")
	private String tipo;
	@Column(name="DESCRIPCION")
	private String descripcion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Combo() {
		super();
	}
	@Override
	public String toString() {
		return "Combo [id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}
	
}
