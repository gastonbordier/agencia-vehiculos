package com.sms.agencia.entidades;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	@Size(min = 3, message = "La marca debe tener al menos 3 caracteres")
	protected String marca;

	@Column(unique = true)
	@Size(min = 3, message = "El modelo debe tener al menos 3 caracteres")
	protected String modelo;

	@Size(min = 3, message = "El color debe tener al menos 3 caracteres")
	protected String color;

	@PositiveOrZero(message = "El stock no puede ser un numero negativo")
	protected int stock;

	@Column(columnDefinition = "decimal(10,2)")
	@Positive(message = "El precio no puede ser un numero negativo ni cero")
	protected float precio;
	
	@Lob
    @Column(length = Integer.MAX_VALUE, nullable = true)
    private byte[] imagen;

	

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

	public String getPrecioString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(getPrecio());
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
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", color=" + color + ", stock=" + stock + ", precio="
				+ precio + "]";
	}

}
