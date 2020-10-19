package com.init.mascotas.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private int idProducto;

	@Column(name="CATEGORIA")
	private String categoria;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PRECIO")
	private double precio;

	@Column(name="STOCK")
	private int stock;

	@Column(name="TIPOANIMAL")
	private String tipoAnimal;

	@Column(name="CANTIDAD")
	private int cantidad;
	
	@Column(name="IMAGEN")
	@Lob
	private byte[] imagen;
	
	@Column(name="ARCHIVOIMAGEN", length = 3000)
	private String archivoImagen;
	// bi-directional many-to-one association to DetallePedido
	// @OneToMany(mappedBy="producto")
	// private List<DetallePedido> detallePedidos;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTipoAnimal() {
		return this.tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	public String getArchivoImagen() {
		return archivoImagen;
	}

	public void setArchivoImagen(String archivoImagen) {
		this.archivoImagen = archivoImagen;
	}
	/*public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setProducto(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setProducto(null);

		return detallePedido;
	}*/

}