package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.init.mascotas.dto.AnimalRequest;
import com.init.mascotas.entities.Animal;
import com.init.mascotas.entities.FiltroAnimal;
import com.init.mascotas.entities.Usuario;
import com.init.mascotas.repository.AnimalRepository;


@RestController
@RequestMapping("api/animales")
public class AnimalController {
	@Autowired
	private AnimalRepository animalRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardarAnimal")
    public Animal placeOrder(@RequestBody AnimalRequest request){
       return animalRepository.save(request.getAnimal());
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
}
