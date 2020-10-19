package com.init.mascotas.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.entities.Producto;
import com.init.mascotas.repository.ProductoRepository;


@RestController
@RequestMapping("api/productos")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getProducto/{id}", method=RequestMethod.GET)
	public ResponseEntity<Producto> getProductoById(@PathVariable("id") Integer id) {
		Optional<Producto> optionalProduct = productoRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	@DeleteMapping(value="/eliminarProducto/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminarProducto(@PathVariable("id") Integer id) {
		this.productoRepository.deleteById(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos")
	public List<Producto> findAllProducts() {
		return productoRepository.findAll();
	}
	
	@GetMapping(path={"/buscarProductoFiltro",})
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Producto> buscarAnimalFiltro(@RequestParam(required = false) String categoria,
			@RequestParam(required = false) String tipoAnimal) {
	return productoRepository.findProductoFiltrado(categoria, tipoAnimal);
	}
	// Guarda un producto
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarProducto")
    public Producto guardarProducto(@RequestBody Producto producto) throws SerialException, SQLException{
		// producto.setIdProducto(this.obtenerUltimoId() +1 );
		byte[] byteArray = Base64.decodeBase64(producto.getArchivoImagen().getBytes());
		producto.setImagen(byteArray);
		return productoRepository.save(producto);
    }
	// Último id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ultimoId")
	public int obtenerUltimoId() {
		return productoRepository.obtenerUltimoIdPedido();
	}
	// Editar Producto
	@PutMapping(value="/editarProducto/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public @Valid Producto editarProducto(@PathVariable("id") Integer id, @Valid @RequestBody Producto producto) {
		producto.setIdProducto(id);
	    return productoRepository.save(producto);
	}
	// Restar Stock
	@CrossOrigin(origins = "http://localhost:4200")
	public void restarStock(Integer idProducto, Integer cantidad) {
		System.out.println("id productooo " + idProducto);
		Optional<Producto> optionalProduct = productoRepository.findById(idProducto);
		if (optionalProduct.isPresent()) {
			ResponseEntity<Producto> producto = ResponseEntity.ok(optionalProduct.get());
			Producto product = producto.getBody();
			product.setStock(product.getStock() - cantidad);
			this.productoRepository.save(product);
		}
	}
}
