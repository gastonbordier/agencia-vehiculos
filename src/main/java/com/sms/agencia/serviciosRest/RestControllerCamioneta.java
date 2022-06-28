package com.sms.agencia.serviciosRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
@RequestMapping("/camioneta-rest")
public class RestControllerCamioneta {

	@Autowired
	private CamionetaRepository repository;

	@GetMapping("/listar")
	public ResponseEntity<Camioneta[]> getPersona(Model model) {
		List<Camioneta> listaCamionetas = repository.findAll();
		Camioneta[] arrayCamionetas = listaCamionetas.toArray(new Camioneta[listaCamionetas.size()]);
		return new ResponseEntity<>(arrayCamionetas,HttpStatus.OK);
	}
	

	@PostMapping
	public void insertar(@RequestBody Camioneta camioneta) {
		repository.save(camioneta);
	}

	@PutMapping
	public void modificar(@RequestBody Camioneta camioneta) {
		repository.save(camioneta);
	}

	@DeleteMapping(value="{id}")
	public void eliminar(@PathVariable int id) {
		repository.deleteById(id);
	}

}
