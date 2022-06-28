package com.sms.agencia.servicios;

import java.util.List;

import com.sms.agencia.entidades.Camioneta;

public interface IVehiculoService<T> {
	void grabar(T entidad);
	List<T> listar();
	T encontrarPorId(int id);
	void eliminarPorId(int id);
	boolean existeId(int id);

}
