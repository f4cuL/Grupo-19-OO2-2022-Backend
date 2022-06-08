package com.trabajopractico.sistema.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "labs")
public class Laboratorio extends Aula {

	private int cantPc;
	private int cantSillas;

	public Laboratorio(int id, int numero, Edificio edificio, int cantPc, int cantSillas) {
		super(id, numero, edificio);
		this.cantPc = cantPc;
		this.cantSillas = cantSillas;
	}

	public Laboratorio() {
	}

	public int getCantPc() {
		return cantPc;
	}

	public void setCantPc(int cantPc) {
		this.cantPc = cantPc;
	}

	public int getCantSillas() {
		return cantSillas;
	}

	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}

}
