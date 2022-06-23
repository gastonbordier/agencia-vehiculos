package com.sms.agencia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.repositories.MotocicletaRepository;

@Service
public class MotocicletaServiceImpl implements IMotocicletaService {

	@Autowired
	private MotocicletaRepository repository;
	
	@Override
	public List<Motocicleta> listar() {
		return repository.findAll();
	}
	
	@Override
	public void grabar(Motocicleta motocicleta) {
		repository.save(motocicleta);
		
	}


	@Override
	public Motocicleta encontrarPorId(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void eliminarPorId(int id) {
		repository.deleteById(id);
	}


	

}
