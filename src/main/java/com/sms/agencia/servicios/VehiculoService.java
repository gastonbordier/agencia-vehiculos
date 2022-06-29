package com.sms.agencia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.agencia.entidades.Vehiculo;
import com.sms.agencia.repositories.VehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService<Vehiculo> {
	
	@Autowired
	private VehiculoRepository repository;

	@Override
	public void grabar(Vehiculo entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> listar() {
		return repository.findAll();
	}

	@Override
	public Vehiculo encontrarPorId(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void eliminarPorId(int id) {
		repository.deleteById(id);;
	}

	@Override
	public boolean existeId(int id) {
		return repository.existsById(id);
	}

}
