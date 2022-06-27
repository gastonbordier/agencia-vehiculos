package com.sms.agencia.entidades;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Positive;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Motocicleta extends Vehiculo {
	@Positive(message = "El precio no puede ser un numero negativo ni cero")
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
