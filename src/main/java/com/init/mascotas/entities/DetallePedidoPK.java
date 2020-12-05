package com.init.mascotas.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_pedido database table.
 * 
 */
@Embeddable
public class DetallePedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PRODUCTO", insertable=false, updatable=false)
	private int idProducto;

	@Column(name="ID_PEDIDO", insertable=false, updatable=false)
	private int idPedido;

	public DetallePedidoPK() {
	}
	public int getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
		if (!(other instanceof DetallePedidoPK)) {
			return false;
		}
		DetallePedidoPK castOther = (DetallePedidoPK)other;
		return 
			(this.idProducto == castOther.idProducto)
			&& (this.idPedido == castOther.idPedido);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProducto;
		hash = hash * prime + this.idPedido;
		
		return hash;
	}
}