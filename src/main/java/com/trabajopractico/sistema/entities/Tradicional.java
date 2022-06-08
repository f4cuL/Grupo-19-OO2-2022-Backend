package com.trabajopractico.sistema.entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value ="trad")
public class Tradicional extends Aula {
	private int cantBancos;
	private String pizarron;
	private boolean tieneProyector;

	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}

	public String getPizarron() {
		return pizarron;
	}

	public void setPizarron(String pizarron) {
		this.pizarron = pizarron;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	public Tradicional(int id, int numero, Edificio edificio, int cantBancos, String pizarron, boolean tieneProyector) {
		super(id, numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}

	public Tradicional() {

	}

}
