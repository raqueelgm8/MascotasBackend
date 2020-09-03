package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.mascotas.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
	@Query(value = "SELECT * FROM ANIMAL u WHERE u.tipoanimal LIKE :tipoAnimal", nativeQuery = true)
	List<Animal> findAnimalTipo(String tipoAnimal);
	
	@Query(value = "INSERT INTO ANIMAL (NOMBRE, DESCRIPCION, RAZA, TIPOANIMAL, TIPOEDAD, EDAD, ADOPTADO, IMAGEN, SEXO)"
			+ "VALUES(:animal.nombre, :animal.descripcion, :animal.raza, :animal.descripcion, :animal.raza,"
			+ ":animal.tipoanimal, :animal.tipoedad, :animal.edad, :animal.adoptado, :animal.imagen, :animal.sexo)", nativeQuery = true)
	Animal guardarAnimal(Animal animal);
	
	@Query(value= "SELECT max(ID_ANIMAL) FROM ANIMAL", nativeQuery = true)
	Integer obtenerUltimoId();
}