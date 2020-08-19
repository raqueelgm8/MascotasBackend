package com.init.mascotas.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pedido database table.
 * 
 */
@Embeddable
public class PedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="ID_PEDIDO")
	private int idPedido;

	public PedidoPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPedido() {
		return this.idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PedidoPK)) {
			return false;
		}
		PedidoPK castOther = (PedidoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idPedido == castOther.idPedido);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idPedido;
		
		return hash;
	}
}