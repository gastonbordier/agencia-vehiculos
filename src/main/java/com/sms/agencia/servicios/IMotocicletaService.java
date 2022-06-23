package com.sms.agencia.servicios;

import java.util.List;

import com.sms.agencia.entidades.Motocicleta;

public interface IMotocicletaService {
	void grabar(Motocicleta motocicleta);
	List<Motocicleta> listar();
	Motocicleta encontrarPorId(int id);
	void eliminarPorId(int id);

}
