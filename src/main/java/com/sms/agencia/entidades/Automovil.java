package com.sms.agencia.entidades;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Automovil extends Vehiculo {
	protected int cantidadRuedas;
	protected int cantidadPuertas;
	protected int capacidadOcupantes;
	protected String tipoCombustible;

	public Automovil() {
	}

	public Automovil(String marca, String modelo, String color, int stock, float precio, int cantidadRuedas,
			int cantidadPuertas, int capacidadOcupantes, String tipoCombustible) {
		super(marca, modelo, color, stock, precio);
		this.cantidadRuedas = cantidadRuedas;
		this.cantidadPuertas = cantidadPuertas;
		this.capacidadOcupantes = capacidadOcupantes;
		this.tipoCombustible = tipoCombustible;
	}

	public int getCantidadRuedas() {
		return cantidadRuedas;
	}

	public void setCantidadRuedas(int cantidadRuedas) {
		this.cantidadRuedas = cantidadRuedas;
	}

	public int getCantidadPuertas() {
		return cantidadPuertas;
	}

	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	public int getCapacidadOcupantes() {
		return capacidadOcupantes;
	}

	public void setCapacidadOcupantes(int capacidadOcupantes) {
		this.capacidadOcupantes = capacidadOcupantes;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	@Override
	public String toString() {
		return "Automovil [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio="
				+ precio + ", cantidadRuedas=" + cantidadRuedas + ", cantidadPuertas=" + cantidadPuertas
				+ ", capacidadOcupantes=" + capacidadOcupantes + ", tipoCombustible=" + tipoCombustible + "]";
	}

}
