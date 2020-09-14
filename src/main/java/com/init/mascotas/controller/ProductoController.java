package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.entities.Animal;
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
}
