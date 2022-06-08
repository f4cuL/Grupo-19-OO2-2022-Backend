package com.trabajopractico.sistema.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Aula {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private int numero;
	
	@ManyToOne(targetEntity = Edificio.class)
	@JoinColumn(name = "id_edificio")
	private Edificio edificio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public Aula(int id, int numero, Edificio edificio) {
		this.id = id;
		this.numero = numero;
		this.edificio = edificio;
	}

	public Aula() {
	}

}
