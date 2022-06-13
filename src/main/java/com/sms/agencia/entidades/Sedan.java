package com.sms.agencia.entidades;

import javax.persistence.Entity;

@Entity
public class Sedan extends Automovil {
	private boolean esDescapotable;

	public Sedan() {
	}

	public Sedan(int cantidadRuedas, int cantidadPuertas, int capacidadOcupantes, String tipoCombustible,
			boolean esDescapotable) {
		super(cantidadRuedas, cantidadPuertas, capacidadOcupantes, tipoCombustible);
		this.esDescapotable = esDescapotable;
	}

	public boolean isEsDescapotable() {
		return esDescapotable;
	}

	public void setEsDescapotable(boolean esDescapotable) {
		this.esDescapotable = esDescapotable;
	}

	@Override
	public String toString() {
		return "Sedan [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio=" + precio
				+ ", cantidadRuedas=" + cantidadRuedas + ", cantidadPuertas=" + cantidadPuertas
				+ ", capacidadOcupantes=" + capacidadOcupantes + ", tipoCombustible=" + tipoCombustible
				+ ", esDescapotable=" + esDescapotable + "]";
	}

}
