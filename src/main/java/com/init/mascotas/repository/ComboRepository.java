package com.init.mascotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.init.mascotas.entities.Combo;

public interface ComboRepository extends JpaRepository<Combo, String>{

	@Query(value = "SELECT * FROM COMBO u WHERE u.tipo LIKE :tipo ORDER BY u.descripcion", nativeQuery = true)
	List<Combo> findComboPorTipo(String tipo);
}
