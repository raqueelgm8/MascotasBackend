package com.init.mascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.init.mascotas.entities.Combo;
import com.init.mascotas.repository.ComboRepository;

@RestController
@RequestMapping("api/combo")
public class ComboController {
	@Autowired
	private ComboRepository comboRepository;
	
	@GetMapping("/getTiposAnimales/{tipoAnimal}")
    public List<Combo> findAnimalTipo(@PathVariable(value="tipoAnimal") String tipo){
        return comboRepository.findComboPorTipo(tipo);
    }

}
