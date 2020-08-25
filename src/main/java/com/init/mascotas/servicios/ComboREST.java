package com.init.mascotas.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.mascotas.dao.ComboDAO;
import com.init.mascotas.entities.Combo;

@RestController
@RequestMapping("api/combos")
public class ComboREST {

	@Autowired
	private ComboDAO comboDAO;
	
	// Devuelve todos los combos
	@RequestMapping(value="combos", method=RequestMethod.GET)
	public ResponseEntity<List<Combo>> getCombos() {
		List<Combo> combos = comboDAO.findAll();
		return ResponseEntity.ok(combos);
	}
	// Devuelve combo por su id
	@RequestMapping(value="{id}", method=RequestMethod.GET) // combos/{id} --> /combos/1
	public ResponseEntity<Combo> getComboById(@PathVariable("id") String id) {
		Optional<Combo> optionalCombo = comboDAO.findById(id);
		if (optionalCombo.isPresent()) {
			return ResponseEntity.ok(optionalCombo.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	// Devuelve combo por su tipo
	@RequestMapping(value="tipo/{tipo}", method=RequestMethod.GET)
	public Iterable<Combo> findComboByType(@PathVariable("tipo") String tipo) {
	      Combo combo = new Combo();
	      combo.setTipo(tipo);
	      Example<Combo> comboTipo = Example.of(combo);
	      Iterable<Combo> combos = this.comboDAO.findAll(comboTipo);
	      return combos;
	  }
}
