package com.trabajopractico.sistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.trabajopractico.sistema.entities.Aula;
import com.trabajopractico.sistema.entities.Edificio;
import com.trabajopractico.sistema.service.impl.GestionDeAulasService;

@RestController
@CrossOrigin(value = "*")
public class GestionDeAulasController {

	@Autowired
	private GestionDeAulasService gestionDeAulasService;

	@PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
	@GetMapping("/aula/{id}")
	public Aula traerAula(@PathVariable int id) {
		return gestionDeAulasService.traer(id);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
	@GetMapping("/edificio/{id}")
	public Edificio traerEdificioConAulas(@PathVariable int id) {
		return gestionDeAulasService.traerEdificioConAulas(id);
	}

}
