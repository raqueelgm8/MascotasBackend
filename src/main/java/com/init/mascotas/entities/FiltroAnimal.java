package com.init.mascotas.entities;

public class FiltroAnimal {
	private boolean adoptado;
	private int edad;
	private String raza;
	private String tipoAnimal;
	private String tipoedad;
	private String sexo;
	public boolean isAdoptado() {
		return adoptado;
	}
	public void setAdoptado(boolean adoptado) {
		this.adoptado = adoptado;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
