package com.init.mascotas.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoPK id;

	@Column(name="APELLIDOS")
	private String apellidos;

	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="EMAIL")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHAPEDIDO")
	private Date fechaPedido;

	@Column(name="METODOPAGO")
	private String metodoPago;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PROVINCIA")
	private String provincia;

	@Column(name="TELEFONO")
	private String telefono;

	@Column(name="TOTAL")
	private double total;
	
	@Column(name="ESTADOPEDIDO")
	private String estadoPedido;
	
	
	//bi-directional many-to-one association to DetallePedido
	/*@OneToMany(mappedBy="pedido")
	private List<DetallePedido> detallePedidos;*/

	//bi-directional many-to-one association to Usuario
	/*@ManyToOne
	@JoinColumn(name="ID_USUARIO", insertable = false, updatable = false)
	private Usuario usuario;*/

	public Pedido() {
	}

	public PedidoPK getId() {
		return this.id;
	}

	public void setId(PedidoPK id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getMetodopago() {
		return this.metodoPago;
	}

	public void setMetodopago(String metodopago) {
		this.metodoPago = metodopago;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*
	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}
*/
	/*public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setPedido(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setPedido(null);

		return detallePedido;
	}*/
/*
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/

}