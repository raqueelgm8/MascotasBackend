package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.mascotas.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
	@Query(value = "SELECT * FROM ANIMAL u WHERE u.tipoanimal LIKE :tipoAnimal", nativeQuery = true)
	List<Animal> findAnimalTipo(String tipoAnimal);
}