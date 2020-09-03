package com.init.mascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.init.mascotas.dto.AnimalRequest;
import com.init.mascotas.entities.Animal;
import com.init.mascotas.repository.AnimalRepository;


@RestController
@RequestMapping("api/animales")
public class AnimalController {
	@Autowired
	private AnimalRepository animalRepository;
	
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
	// Último id
	/*@GetMapping("/ultimoId")
	public int obtenerUltimoId() {
		return animalRepository.obtenerUltimoId();
	}*/
	/*@RequestMapping(value = "/guardarAnimal", method = RequestMethod.POST)
    public Animal guardarAnimal(@Valid @RequestBody Animal animal) {
        return this.animalRepository.guardarAnimal(animal);
    }*/
}
