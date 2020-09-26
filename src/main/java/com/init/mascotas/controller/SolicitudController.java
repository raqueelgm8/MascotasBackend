package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.init.mascotas.entities.Solicitud;
import com.init.mascotas.entities.SolicitudPK;
import com.init.mascotas.repository.SolicitudRepository;

@RestController
@RequestMapping("api/solicitudes")
public class SolicitudController {
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@RequestMapping(value="/obtenerSolicitudesIdUsuario/{idUsuario}", method=RequestMethod.GET)
    public List<Solicitud> obtenerSolicitudesIdUsuario(@PathVariable(value="idUsuario") Integer idUsuario){
       return this.solicitudRepository.solicitudesPorIdUsuario(idUsuario);
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarSolicitud/{idUsuario}/{idSolicitud}/{idAnimal}")
    void eliminarSolicitud(@PathVariable(value="idUsuario") Integer idUsuario,
    							  @PathVariable(value="idSolicitud") Integer idSolicitud,
    							  @PathVariable(value="idAnimal") Integer idAnimal){
       SolicitudPK id = new SolicitudPK();
       id.setIdAnimal(idAnimal);
       id.setIdSolicitud(idSolicitud);
       id.setIdUsuario(idUsuario);
       this.solicitudRepository.deleteById(id);
    }
	@RequestMapping(value="/obtenerSolicitudPorId/{idUsuario}/{idSolicitud}/{idAnimal}", method=RequestMethod.GET)
    public Optional<Solicitud> obtenerSolicitudPorId(@PathVariable(value="idUsuario") Integer idUsuario,
			  @PathVariable(value="idSolicitud") Integer idSolicitud,
			  @PathVariable(value="idAnimal") Integer idAnimal){
		SolicitudPK id = new SolicitudPK();
        id.setIdAnimal(idAnimal);
        id.setIdSolicitud(idSolicitud);
        id.setIdUsuario(idUsuario);
        return this.solicitudRepository.findById(id);
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarSolicitud")
    public Solicitud guardarSolicitud(@RequestBody Solicitud guardarSolicitud){
		SolicitudPK pk = guardarSolicitud.getId();
		pk.setIdSolicitud(obtenerUltimoId());
		guardarSolicitud.setId(pk);
       return solicitudRepository.save(guardarSolicitud);
    }
	// Último id
	@GetMapping("/ultimoId")
	public int obtenerUltimoId() {
		return solicitudRepository.obtenerUltimoId();
	}
	// Editar solicitud por id
	@PutMapping(value="/editarSolicitud")
	@CrossOrigin(origins = "http://localhost:4200")
	public Solicitud editarUsuario(@Valid @RequestBody Solicitud solicitud) {
	    Solicitud solicitudUpdated = solicitudRepository.save(solicitud);
	    return solicitudUpdated;
	}
}
