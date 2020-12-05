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

import com.init.mascotas.entities.Solicitud;
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
	@DeleteMapping("/eliminarSolicitud/{idSolicitud}")
    void eliminarSolicitud(@PathVariable(value="idSolicitud") Integer idSolicitud){
       this.solicitudRepository.deleteById(idSolicitud);
    }
	@RequestMapping(value="/obtenerSolicitudPorId/{idSolicitud}", method=RequestMethod.GET)
    public Optional<Solicitud> obtenerSolicitudPorId(@PathVariable(value="idSolicitud") Integer idSolicitud){
        return this.solicitudRepository.findById(idSolicitud);
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarSolicitud")
    public Solicitud guardarSolicitud(@RequestBody Solicitud guardarSolicitud){
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
	// Editar estado de la solicitud
	@PutMapping(value="/updateEstado/{idSolicitud}/{estado}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void updateEstadoSolicitud(@PathVariable("idSolicitud") Integer idSolicitud, @PathVariable("estado") String estado) {
		this.solicitudRepository.updateEstadoSolicitud(idSolicitud, estado);
		Optional<Solicitud> solicitud = this.obtenerSolicitudPorId(idSolicitud);
		int idAnimal = solicitud.get().getIdAnimal();
		if (estado.equals("Aceptada")){
			this.solicitudRepository.updateEstadoSolicitudDenegado(idSolicitud, idAnimal, "Denegada");
		}
	}
	
	// Devuelve todos las las solicitudes de un animal
	@RequestMapping(value="/obtenerSolicitudesAnimal/{idAnimal}", method=RequestMethod.GET)
    public List<Solicitud> obtenerSolicitudesIdAnimal(@PathVariable(value="idAnimal") Integer idAnimal){
       return this.solicitudRepository.solicitudesPorAnimal(idAnimal);
    }
	
	// Devuelve todos las las solicitudes
	@RequestMapping(value="solicitudes", method=RequestMethod.GET)
	public ResponseEntity<List<Solicitud>> getUsuarios() {
		List<Solicitud> solicitudes = this.solicitudRepository.findAll();
		return ResponseEntity.ok(solicitudes);
	}
}
