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
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.controller.PedidoController;
import com.init.mascotas.entities.Pedido;
import com.init.mascotas.entities.PedidoPK;
import com.init.mascotas.repository.PedidoRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getPedido/{idUsuario}/{idPedido}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> getProductoById(@PathVariable("id") Integer idUsuario, @PathVariable("id") Integer idPedido) {
		PedidoPK pk = new PedidoPK(idUsuario, idPedido);
		Optional<Pedido> optionalPedido = pedidoRepository.findById(pk);
		if (optionalPedido.isPresent()) {
			return ResponseEntity.ok(optionalPedido.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	@DeleteMapping(value="/eliminarPedido/{idUsuario}/{idPedido}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminarPedido(@PathVariable("id") Integer idUsuario, @PathVariable("id") Integer idPedido){
		PedidoPK pk = new PedidoPK(idUsuario, idPedido);
		this.pedidoRepository.deleteById(pk);
	}
	@GetMapping("/pedidos")
	public List<Pedido> findAllPedidos() {
		return pedidoRepository.findAll();
	}
}