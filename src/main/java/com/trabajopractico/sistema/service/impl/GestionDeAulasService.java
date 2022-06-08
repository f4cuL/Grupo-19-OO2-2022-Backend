package com.trabajopractico.sistema.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trabajopractico.sistema.entities.Administrador;
import com.trabajopractico.sistema.entities.Aula;
import com.trabajopractico.sistema.entities.Edificio;
import com.trabajopractico.sistema.entities.Espacio;
import com.trabajopractico.sistema.entities.Laboratorio;
import com.trabajopractico.sistema.entities.Usuario;
import com.trabajopractico.sistema.repositories.AulaRepository;
import com.trabajopractico.sistema.repositories.EdificioRepository;
import com.trabajopractico.sistema.repositories.EspacioRepository;

@Service
public class GestionDeAulasService {

	@Autowired
	private EdificioRepository edificioRepository;

	@Autowired
	private AulaRepository aulaRepository;

	@Autowired
	private EspacioRepository espacioRepository;

	public Aula traer(int id) {
		return aulaRepository.findById(id).orElse(null);
	}

	public Edificio traerEdificioConAulas(int id) {
		return edificioRepository.findById(id).orElse(null);
	}

	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		return espacioRepository.traer(fecha, turno, aula.getId());
	}

	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
		Espacio aux = new Espacio();
		aux.setFecha(fecha);
		aux.setTurno(turno);
		aux.setAula(aula);
		aux.setLibre(libre);

		if (this.traer(fecha, turno, aula) == null) {
			return espacioRepository.save(aux).getId();
		} else {
			throw new Exception();
		}
	}

	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) {
		int aux = LocalDate.of(anio, mes, 1).lengthOfMonth();
		for (int i = 1; i <= aux; i++) {
			try {
				this.agregar(LocalDate.of(anio, mes, i), turno, aula, false);
			} catch (Exception e) {
				System.out.println("horario ocupado");
			}
		}
	}

	public void liberarTurno(LocalDate fecha, char turno, Aula aula) {
		Espacio aux = this.traer(fecha, turno, aula);
		espacioRepository.delete(aux);
	}

	public List<Espacio> traerTurnosDeAula(Aula aula) {

		return espacioRepository.traerEspaciosDeAula(aula.getId());
	}

	public Espacio traerEspacio(int id) {
		return espacioRepository.findById(id).orElse(null);
	}

	public Aula agregarAula(Aula aula) {
		return aulaRepository.save(aula);
	}
	

}
