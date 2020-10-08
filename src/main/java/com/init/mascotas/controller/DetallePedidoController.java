package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.init.mascotas.entities.DetallePedido;
import com.init.mascotas.entities.DetallePedidoPK;
import com.init.mascotas.entities.Producto;
import com.init.mascotas.repository.DetallePedidoRepository;
import com.init.mascotas.repository.ProductoRepository;

@RestController
@RequestMapping("api/detalles")
public class DetallePedidoController {
	
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
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
	// Devuelve los detalle pedido por idUsuario e idPedido
	@RequestMapping(value="/detallesPedidoPorPedido/{idUsuario}/{idPedido}", method=RequestMethod.GET)
	public List<DetallePedido> findDetallesPorPedido(
			@PathVariable(value="idUsuario") Integer idUsuario,
			@PathVariable(value="idPedido") Integer idPedido) {
			return this.detallePedidoRepository.findDetallesPorPedido(idUsuario, idPedido);
	}
	// Guardar los Detalle Pedidp
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarDetalles/{idUsuario}/{idPedido}")
    public List<DetallePedido> guardarDetalles(
    		@PathVariable(value="idUsuario") Integer idUsuario,
			@PathVariable(value="idPedido") Integer idPedido,
    		@RequestBody List<DetallePedido> detallesPedido){
				if (detallesPedido.size() > 0) {
					for (DetallePedido detallePedido: detallesPedido) {
						DetallePedidoPK pk = new DetallePedidoPK();
						pk.setIdPedido(idPedido);
						pk.setIdUsuario(idUsuario);
						pk.setIdProducto(detallePedido.getId().getIdProducto());
						detallePedido.setId(pk);
						System.out.println(detallePedido.getId().getIdProducto());
						restarStock(detallePedido.getId().getIdProducto(), detallePedido.getCantidad());
						this.detallePedidoRepository.save(detallePedido);
					}
					return this.findDetallesPorPedido(idUsuario, idPedido);
				} else {
					return null;
			}
	}
	// Restar Stock
		public void restarStock(Integer idProducto, Integer cantidad) {
			System.out.println("id productooo " + idProducto);
			Optional<Producto> optionalProduct = productoRepository.findById(idProducto);
			if (optionalProduct.isPresent()) {
				System.out.println("he entrado");
				ResponseEntity<Producto> producto = ResponseEntity.ok(optionalProduct.get());
				System.out.println(producto.toString());
				Producto product = producto.getBody();
				product.setStock(product.getStock() - cantidad);
				this.productoRepository.save(product);
			}
		}
}
