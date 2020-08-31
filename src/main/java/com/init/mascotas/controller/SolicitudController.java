package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.entities.Solicitud;
import com.init.mascotas.repository.SolicitudRepository;

@RestController
@RequestMapping("api/solicitudes")
public class SolicitudController {
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@RequestMapping(value="/obtenerSolicitudesIdUsuario/{idUsuario}", method=RequestMethod.GET)
    public List<Solicitud> placeOrder(@PathVariable(value="idUsuario") Integer idUsuario){
       return this.solicitudRepository.solicitudesPorIdUsuario(idUsuario);
    }
	
}
