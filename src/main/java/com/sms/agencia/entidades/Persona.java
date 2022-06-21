package com.sms.agencia.entidades;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;


public class Persona {
	@NotNull
	@Digits(fraction = 1, integer = 10)
	private int id;
	@NotEmpty
	@Size(min = 5)
	private String nombre;

	public Persona() {
		super();
	}

	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min = 5)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

}
