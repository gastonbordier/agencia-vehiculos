package com.sms.agencia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.repositories.MotocicletaRepository;

@RestController
@RequestMapping("/motocicletas/servicioRest")
public class RestControllerMotocicleta {

	@Autowired
	private MotocicletaRepository repository;

	@GetMapping
	public List<Motocicleta> listarMotos() {
		return repository.findAll();
	}

	@PostMapping
	public void insertar(@RequestBody Motocicleta motocicleta) {
		repository.save(motocicleta);
	}

	@PutMapping
	public void modificar(@RequestBody Motocicleta motocicleta) {
		repository.save(motocicleta);
	}

	@DeleteMapping(value="{id}")
	public void eliminar(@PathVariable int id) {
		repository.deleteById(id);
	}

}
