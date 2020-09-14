package com.init.mascotas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.mascotas.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
	@Query(value = "SELECT * FROM ANIMAL u WHERE u.tipoanimal LIKE :tipoAnimal ORDER BY u.raza", nativeQuery = true)
	List<Animal> findAnimalTipo(String tipoAnimal);
	
	@Query(value = "INSERT INTO ANIMAL (NOMBRE, DESCRIPCION, RAZA, TIPOANIMAL, TIPOEDAD, EDAD, ADOPTADO, IMAGEN, SEXO)"
			+ "VALUES(:animal.nombre, :animal.descripcion, :animal.raza, :animal.descripcion, :animal.raza,"
			+ ":animal.tipoanimal, :animal.tipoedad, :animal.edad, :animal.adoptado, :animal.imagen, :animal.sexo)", nativeQuery = true)
	Animal guardarAnimal(Animal animal);
	
	@Query(value= "SELECT max(ID_ANIMAL) FROM ANIMAL", nativeQuery = true)
	Integer obtenerUltimoId();
	

	@Query(value = "SELECT * FROM ANIMAL u WHERE u.tipoanimal LIKE :tipoAnimal AND u.raza LIKE :raza ORDER BY u.raza", nativeQuery = true)
	List<Animal> buscarAnimalFiltro(String tipoAnimal, String raza);
	
	@Query(value = "SELECT * FROM ANIMAL u WHERE u.tipoanimal LIKE :tipoAnimal AND (:raza is null or u.raza LIKE :raza)"
			+ "AND (:tipoEdad is null or u.tipoedad LIKE :tipoEdad) AND (:edad is null or u.edad >= :edad)"
			+ " AND (:adoptado is null or u.adoptado = :adoptado) AND (:sexo is null or u.sexo LIKE :sexo) "
			+ "ORDER BY u.raza", nativeQuery = true)
	List<Animal> findByAllAtributtes(String tipoAnimal, String raza,
			Integer edad, String tipoEdad, Boolean adoptado, String sexo);
}