package com.sms.agencia.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String marca;
	@Column(unique = true)
	protected String modelo;
	protected String color;
	protected int stock;
	@Column(columnDefinition = "decimal(10,2)")
	protected float precio;

	public Vehiculo() {
	}

	public Vehiculo(String marca, String modelo, String color, int stock, float precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.stock = stock;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio="
				+ precio + "]";
	}

}
