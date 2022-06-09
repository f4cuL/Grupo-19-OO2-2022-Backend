package com.trabajopractico.sistema.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.trabajopractico.sistema.entities.Aula;
import com.trabajopractico.sistema.entities.Edificio;
import com.trabajopractico.sistema.entities.Espacio;
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
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
	@GetMapping("/edificio/{dia}-{mes}-{anio}/{turno}/{id}")
	public Espacio traer(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio, @PathVariable char turno, @PathVariable int idAula) {
		
		return gestionDeAulasService.traer(LocalDate.of(anio, mes, dia), turno, gestionDeAulasService.traer(idAula));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/espacio")
	public int agregar(@RequestBody LocalDate fecha,@RequestBody char turno,@RequestBody Aula aula,@RequestBody boolean libre) throws Exception {
		return gestionDeAulasService.agregar(fecha, turno, aula, libre);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/espacioMes")
	public void agregarEspacioMes(@RequestBody int mes,@RequestBody int anio,@RequestBody char turno,@RequestBody Aula aula) {
		gestionDeAulasService.agregarEspacioMes(mes, anio, turno, aula);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/edificio/{dia}-{mes}-{anio}/{turno}/{id}")
	public void liberarTurno(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio, @PathVariable char turno, @PathVariable int idAula) {
		gestionDeAulasService.liberarTurno(LocalDate.of(anio, mes, dia), turno, gestionDeAulasService.traer(idAula));
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
	@GetMapping("/turnos/{id}")
	public List<Espacio> traerTurnosDeAula(@PathVariable int id) {

		return gestionDeAulasService.traerTurnosDeAula(gestionDeAulasService.traer(id));
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('AUDITORIA')")
	@GetMapping("/espacio/{id}")
	public Espacio traerEspacio(@PathVariable int id) {
		return gestionDeAulasService.traerEspacio(id);
	}

	@PostMapping("/aula")
	public Aula agregarAula(@RequestBody Aula aula) {
		return gestionDeAulasService.agregarAula(aula);
	}
	

}
