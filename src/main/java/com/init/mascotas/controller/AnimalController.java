package com.init.mascotas.controller;

import java.sql.Blob;
import java.util.*;
import javax.sql.rowset.serial.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.init.mascotas.entities.Animal;
import com.init.mascotas.repository.AnimalRepository;

@RestController
@RequestMapping("api/animales")
public class AnimalController {
	@Autowired
	private AnimalRepository animalRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarAnimal")
    public Animal guardarAnimal(@RequestBody Animal animal) throws SerialException, SQLException{
		byte[] byteArray = Base64.decodeBase64(animal.getArchivoImagen().getBytes());
		animal.setImagen(byteArray);
		return animalRepository.save(animal);
    }
	@GetMapping("/animales")
	public List<Animal> findAllAnimals() {
		return animalRepository.findAll();
	}
	
	@GetMapping("/getTiposAnimales/{tipoAnimal}")
    public List<Animal> findAnimalTipo(@PathVariable(value="tipoAnimal") String tipoAnimal){
        return animalRepository.findAnimalTipo(tipoAnimal);
    }
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.GET})
	@RequestMapping(value="/getAnimalById/{id}", method=RequestMethod.GET) // animales/{id} --> /animales/1
	public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Integer id) {
		Optional<Animal> optionalAnimal = animalRepository.findById(id);
		if (optionalAnimal.isPresent()) {
			return ResponseEntity.ok(optionalAnimal.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	@DeleteMapping(value="/eliminarAnimal/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void eliminarAnimal(@PathVariable("id") Integer id) {
		this.animalRepository.deleteById(id);
	}
	@GetMapping(path={"/buscarAnimalFiltro/{tipo}",})
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Animal> buscarAnimalFiltro(@PathVariable("tipo") String tipo, @RequestParam(required = false) String raza,
		@RequestParam(required = false) Integer edad, @RequestParam(required = false) String tipoEdad,
		@RequestParam(required = false) Boolean adoptado, @RequestParam(required = false) String sexo) {
	
	return animalRepository.findByAllAtributtes(tipo, raza, edad, tipoEdad, adoptado, sexo);
	}
	// Editar animal
	@PutMapping(value="/editarAnimal/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Animal editarAnimal(@PathVariable("id") Integer id, @Valid @RequestBody Animal animal) {
		animal.setIdAnimal(id);
	    return animalRepository.save(animal);
	}
	// Último id
	@GetMapping("/ultimoId")
	public int obtenerUltimoId() {
		return animalRepository.obtenerUltimoId();
	}
}
