package com.init.mascotas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.init.mascotas.entities.Combo;

public interface ComboDAO extends JpaRepository<Combo, String>, JpaSpecificationExecutor<Combo>, CrudRepository<Combo, String>{
	
}
