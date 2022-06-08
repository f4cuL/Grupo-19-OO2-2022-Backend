package com.trabajopractico.sistema.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "edificio")
public class Edificio {

	@Id
	@Column(name = "edificio_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String edificio;
	
	
	@OneToMany (mappedBy = "edificio")
	private Set<Aula> aulas = new HashSet<Aula>();

	public Edificio(int id, String edificio, Set<Aula> aulas) {
		this.id = id;
		this.edificio = edificio;
		this.aulas = aulas;
	}

	public Edificio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

}
