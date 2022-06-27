package com.sms.agencia.entidades;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Automovil extends Vehiculo {
	
	@Min(value = 1, message = "La cantidad de ruedas debe ser mayor o igual a 1.")
	@Max(value = 30, message = "La cantidad de ruedas debe ser menor o igual a 30.")
	protected int cantidadRuedas;
	@Min(value = 1, message = "La cantidad de puertas debe ser mayor o igual a 1.")
	@Max(value = 10, message = "La cantidad de puertas debe ser menor o igual a 10.")
	protected int cantidadPuertas;
	@Min(value = 1, message = "La capacidad de ocupantes debe ser mayor o igual a 1.")
	@Max(value = 10, message = "La capacidad de ocupantes debe ser menor o igual a 10.")
	protected int capacidadOcupantes;
	@Size(min = 3, message = "El tipo de combustible debe tener al menos 3 caracteres")
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
