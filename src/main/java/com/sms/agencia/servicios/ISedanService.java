package com.sms.agencia.servicios;

import java.util.List;

import com.sms.agencia.entidades.Sedan;

public interface ISedanService {
	void grabar(Sedan sedan);
	List<Sedan> listar();
	Sedan encontrarPorId(int id);
	void eliminarPorId(int id);
	boolean existeId(int id);

}
