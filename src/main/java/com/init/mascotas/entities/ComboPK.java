package com.init.mascotas.entities;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the combo database table.
 * 
 */
@Embeddable
public class ComboPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	private String tipo;

	public ComboPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ComboPK)) {
			return false;
		}
		ComboPK castOther = (ComboPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.tipo.equals(castOther.tipo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.tipo.hashCode();
		
		return hash;
	}
}