package com.sms.agencia.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.agencia.entidades.Vehiculo;
import com.sms.agencia.repositories.VehiculoRepository;

@Service
public class VehiculoService{
	
	@Autowired
	private VehiculoRepository repository;

	public void grabar(Vehiculo entidad) {
		// TODO Auto-generated method stub
		
	}

	public List<Vehiculo> listar() {
		return repository.findAll();
	}
	
	public List<Vehiculo> listarTresVehiculosAleatorios() {
		List<Vehiculo> listaAleatoria = new ArrayList<>();
		int cantidadAutos = this.listar().size();

		int[] numerosRandom = new int[3];
		for (int i = 0; i < numerosRandom.length; i++) {
			numerosRandom[i] = (int) (Math.random() * (cantidadAutos - 1) + 1);
			listaAleatoria.add(encontrarPorId(numerosRandom[i]));
		}
		
		
		return listaAleatoria;
	}
	
	

	public Vehiculo encontrarPorId(int id) {
		return repository.findById(id).get();
	}

	public void eliminarPorId(int id) {
		repository.deleteById(id);;
	}

	public boolean existeId(int id) {
		return repository.existsById(id);
	}

}
