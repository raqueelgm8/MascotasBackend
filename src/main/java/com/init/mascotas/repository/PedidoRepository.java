package com.init.mascotas.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.controller.PedidoController;

@RestController
@RequestMapping("api/pedidos")
public class PedidoRepository {
	@Autowired
	private PedidoController pedidoController;
}
