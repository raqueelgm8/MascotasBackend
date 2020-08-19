package com.init.mascotas.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Animal;

public interface AnimalDAO extends JpaRepository<Animal, Integer>, JpaSpecificationExecutor<Animal>, CrudRepository<Animal, Integer>{
	

}
