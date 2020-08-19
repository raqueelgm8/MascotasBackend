package com.init.mascotas.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.dao.AnimalDAO;
import com.init.mascotas.entities.Animal;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping("api/animales")
public class MascotasREST {

	@Autowired
	private AnimalDAO animalDAO;
	
	// Devuelve todos los animales
	@RequestMapping(value="animales", method=RequestMethod.GET)
	public ResponseEntity<List<Animal>> getAnimales() {
		List<Animal> animales = animalDAO.findAll();
		return ResponseEntity.ok(animales);
	}
	// Devuelve animal por su id
	@RequestMapping(value="{id}", method=RequestMethod.GET) // animales/{id} --> /animales/1
	public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Integer id) {
		Optional<Animal> optionalAnimal = animalDAO.findById(id);
		if (optionalAnimal.isPresent()) {
			return ResponseEntity.ok(optionalAnimal.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// Devuelve animales por su tipo
	/*@RequestMapping(value="tipo/{tipoAnimal}", method=RequestMethod.GET)
	public Iterable<Animal> findAnimalByType(@PathVariable("tipoAnimal") String tipoAnimal) {
		  Animal animal = new Animal();
		  animal.setNombre(tipoAnimal);
		  System.out.println(tipoAnimal);
		  System.out.println(animal);
		  
	      Example<Animal> animalTipo = Example.of(animal);
	      System.out.println(animalTipo);
	      Iterable<Animal> animales = this.animalDAO.findAll(animalTipo);
	      return animales;
	  }
	
	@GetMapping("/cars")
    public ResponseEntity<List<Animal>> searchForCars(@SearchSpec Specification<Animal> specs) {
        return new ResponseEntity<>(animalDAO.findAll(Specification.where(specs)), HttpStatus.OK);
    }*/
	@RequestMapping(value="/tipo/{tipo_animal}", method=RequestMethod.GET)
	public Iterable<Animal> findByAnimalType(String tipo_animal) {
		Animal animal = new Animal();
		  animal.setNombre(tipo_animal);
		  System.out.println(tipo_animal);
		  System.out.println(animal);
		  
	      Example<Animal> animalTipo = Example.of(animal);
	      System.out.println(animalTipo);
	      Iterable<Animal> animales = this.animalDAO.findAll(animalTipo);
	      return animales;
	}
	
	
	// Guarda un animal
	
	// Elimina un animal
}
