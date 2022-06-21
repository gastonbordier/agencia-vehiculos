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
	public List<Motocicleta> findAll() {
		return repository.findAll();
	}
	
	@Override
	public void save(Motocicleta motocicleta) {
		repository.save(motocicleta);
		
	}


	@Override
	public Motocicleta findById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}


	

}
