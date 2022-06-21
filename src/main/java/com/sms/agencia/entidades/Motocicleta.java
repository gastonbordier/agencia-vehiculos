package com.sms.agencia.entidades;

import javax.persistence.Entity;

@Entity
public class Motocicleta extends Vehiculo {
	private int cilindrada;

	public Motocicleta() {
	}

	public Motocicleta(String marca, String modelo, String color, int stock, float precio, int cilindrada) {
		super(marca, modelo, color, stock, precio);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Motocicleta [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio="
				+ precio + ", cilindrada=" + cilindrada + "]";
	}

}
