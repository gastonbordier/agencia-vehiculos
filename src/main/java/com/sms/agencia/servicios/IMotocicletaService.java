package com.sms.agencia.servicios;

import java.util.List;

import com.sms.agencia.entidades.Motocicleta;

public interface IMotocicletaService {
	void save(Motocicleta motocicleta);
	List<Motocicleta> findAll();
	Motocicleta findById(int id);
	void deleteById(int id);

}
