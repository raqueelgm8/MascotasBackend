package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.entities.DetallePedido;
import com.init.mascotas.entities.DetallePedidoPK;
import com.init.mascotas.entities.Usuario;
import com.init.mascotas.repository.DetallePedidoRepository;

@RestController
@RequestMapping("api/detalles")
public class DetallePedidoController {
	
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	// Devuelve todos los detallesPedido
	@RequestMapping(value="/detallesPedido", method=RequestMethod.GET)
	public ResponseEntity<List<DetallePedido>> getAllDetalles() {
		List<DetallePedido> detallesPedido = detallePedidoRepository.findAll();
		return ResponseEntity.ok(detallesPedido);
	}
	// Devuelve todos los detallesPedido
	@RequestMapping(value="/detallesPedido/{idUsuario}/{idPedido}/{idProducto}", method=RequestMethod.GET)
	public ResponseEntity<DetallePedido> getDetallePedidoId(
			@PathVariable(value="idUsuario") Integer idUsuario,
			@PathVariable(value="idPedido") Integer idPedido,
			@PathVariable(value="idProducto") Integer idProducto) {
		DetallePedidoPK pk = new DetallePedidoPK();
		pk.setIdPedido(idPedido);
		pk.setIdProducto(idProducto);
		pk.setIdUsuario(idUsuario);
		Optional<DetallePedido> detallePedido = this.detallePedidoRepository.findById(pk);
		if (detallePedido.isPresent()) {
			return ResponseEntity.ok(detallePedido.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// 
	@RequestMapping(value="/detallesPedidoPorPedido/{idUsuario}/{idPedido}", method=RequestMethod.GET)
	public List<DetallePedido> findDetallesPorPedido(
			@PathVariable(value="idUsuario") Integer idUsuario,
			@PathVariable(value="idPedido") Integer idPedido) {
			return this.detallePedidoRepository.findDetallesPorPedido(idUsuario, idPedido);
	}
}
