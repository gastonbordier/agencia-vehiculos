package com.sms.agencia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.agencia.entidades.Camioneta;
import com.sms.agencia.entidades.Sedan;
import com.sms.agencia.entidades.Vehiculo;
import com.sms.agencia.repositories.CamionetaRepository;
import com.sms.agencia.repositories.SedanRepository;

@Service
public class SedanService implements IVehiculoService<Sedan> {

	@Autowired
	private SedanRepository repository;
	
	@Override
	public List<Sedan> listar() {
		return repository.findAll();
	}
	
	@Override
	public void grabar(Sedan sedan) {
		repository.save(sedan);
		
	}

	@Override
	public Sedan encontrarPorId(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void eliminarPorId(int id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existeId(int id) {
		return repository.existsById(id);
	}


	

}
