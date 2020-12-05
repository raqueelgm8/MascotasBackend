package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.controller.PedidoController;
import com.init.mascotas.entities.Pedido;
import com.init.mascotas.repository.PedidoRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getPedido/{idPedido}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> getProductoById(@PathVariable("idPedido") Integer idPedido) {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(idPedido);
		if (optionalPedido.isPresent()) {
			return ResponseEntity.ok(optionalPedido.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	@DeleteMapping(value="/eliminarPedido/{idUsuario}/{idPedido}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminarPedido( @PathVariable("idPedido") Integer idPedido){
		this.pedidoRepository.deleteById(idPedido);
	}
	@GetMapping("/pedidos")
	public List<Pedido> findAllPedidos() {
		return pedidoRepository.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pedidosUsuario/{idUsuario}")
	public List<Pedido> findPedidosUsuario(@PathVariable("idUsuario") Integer idUsuario) {
		return pedidoRepository.findPedidosUsuario(idUsuario);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarPedido/{idUsuario}")
    public Pedido guardarPedido(
    		@PathVariable("idUsuario") Integer idUsuario,
    		@RequestBody Pedido guardarPedido) {
		guardarPedido.setIdUsuario(idUsuario);
		return pedidoRepository.save(guardarPedido);
       
    }
	// Editar Pedido por id
	@PutMapping(value="/editarPedido")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pedido editarPedido(@Valid @RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	// Último id
	@GetMapping("/ultimoId")
	public int obtenerUltimoId() {
		return pedidoRepository.obtenerUltimoIdPedido();
	}
	// Editar estado del pedido
	@PutMapping(value="/updateEstado/{idPedido}/{estado}")
	@CrossOrigin(origins = "*", methods= {RequestMethod.PUT,RequestMethod.PUT})
	public void updateEstado(@PathVariable("idPedido") Integer idPedido, @PathVariable("estado") String estado) {
		this.pedidoRepository.updateEstado(idPedido, estado);
	}
}