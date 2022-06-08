package com.trabajopractico.sistema.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "espacio")
public class Espacio {
	
	@Id
	private int id;
	private LocalDate fecha;
	private char turno;
	
	@JoinColumn(name = "aula_id" , referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private Aula aula;
	private boolean libre;

	public Espacio(int id, LocalDate fecha, char turno, Aula aula, boolean libre) {
		this.id = id;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}
	
	public Espacio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

}
