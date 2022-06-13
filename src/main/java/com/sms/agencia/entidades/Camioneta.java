package com.sms.agencia.entidades;

import javax.persistence.Entity;

@Entity
public class Camioneta extends Automovil {
	private int taraToneladas;
	private int capacidadToneladas;

	public Camioneta() {
	}

	public Camioneta(String marca, String modelo, String color, int stock, float precio, int cantidadRuedas,
			int cantidadPuertas, int capacidadOcupantes, String tipoCombustible, int taraToneladas,
			int capacidadToneladas) {
		super(marca, modelo, color, stock, precio, cantidadRuedas, cantidadPuertas, capacidadOcupantes,
				tipoCombustible);
		this.taraToneladas = taraToneladas;
		this.capacidadToneladas = capacidadToneladas;
	}

	public int getTaraToneladas() {
		return taraToneladas;
	}

	public void setTaraToneladas(int taraToneladas) {
		this.taraToneladas = taraToneladas;
	}

	public int getCapacidadToneladas() {
		return capacidadToneladas;
	}

	public void setCapacidadToneladas(int capacidadToneladas) {
		this.capacidadToneladas = capacidadToneladas;
	}

	@Override
	public String toString() {
		return "Camioneta [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio="
				+ precio + ", cantidadRuedas=" + cantidadRuedas + ", cantidadPuertas=" + cantidadPuertas
				+ ", capacidadOcupantes=" + capacidadOcupantes + ", tipoCombustible=" + tipoCombustible
				+ ", taraToneladas=" + taraToneladas + ", capacidadToneladas=" + capacidadToneladas + "]";
	}

}
