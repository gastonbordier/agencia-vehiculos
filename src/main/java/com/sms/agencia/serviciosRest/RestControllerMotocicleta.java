package com.sms.agencia.serviciosRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.agencia.entidades.Camioneta;
import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.repositories.CamionetaRepository;
import com.sms.agencia.repositories.MotocicletaRepository;

@RestController
@RequestMapping("/motocicleta-rest")
public class RestControllerMotocicleta {

	@Autowired
	private MotocicletaRepository repository;

	@CrossOrigin
	@GetMapping("/listar")
	public ResponseEntity<Motocicleta[]> getMotocicletas(Model model) {
		List<Motocicleta> listaMotocicletas= repository.findAll();
		Motocicleta[] arrayMotocicletas = listaMotocicletas.toArray(new Motocicleta[listaMotocicletas.size()]);
		return new ResponseEntity<>(arrayMotocicletas,HttpStatus.OK);
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
