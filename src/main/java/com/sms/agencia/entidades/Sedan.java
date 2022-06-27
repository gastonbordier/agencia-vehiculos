package com.sms.agencia.entidades;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Sedan extends Automovil {
	private boolean esDescapotable;

	

	public Sedan() {
	}

	public Sedan(String marca, String modelo, String color, int stock, float precio, int cantidadRuedas,
			int cantidadPuertas, int capacidadOcupantes, String tipoCombustible, boolean esDescapotable) {
		super(marca, modelo, color, stock, precio, cantidadRuedas, cantidadPuertas, capacidadOcupantes, tipoCombustible);
		this.esDescapotable = esDescapotable;
	}

	public String getEsDescapotable() {
		return this.esDescapotable ? "Si" : "No";
	}

	public void setEsDescapotable(String esDescapotable) {
		this.esDescapotable = esDescapotable.toLowerCase().equals("si") ? true : false;
	}

	@Override
	public String toString() {
		return "Sedan [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio=" + precio
				+ ", cantidadRuedas=" + cantidadRuedas + ", cantidadPuertas=" + cantidadPuertas
				+ ", capacidadOcupantes=" + capacidadOcupantes + ", tipoCombustible=" + tipoCombustible
				+ ", esDescapotable=" + esDescapotable + "]";
	}

}
