package com.init.mascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.init.mascotas.dto.AnimalRequest;
import com.init.mascotas.entities.Animal;
import com.init.mascotas.repository.AnimalRepository;


@RestController
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
}
