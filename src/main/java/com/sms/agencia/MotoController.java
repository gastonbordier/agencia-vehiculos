package com.sms.agencia;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.agencia.dataMotocicletas.Motocicleta;
import com.sms.agencia.dataMotocicletas.MotocicletaRepository;

@Controller
@RequestMapping("/motocicletas")
public class MotoController {
	
	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private MotocicletaRepository repository;

	@GetMapping
	public String getListadoMotos(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		List<Motocicleta> lista = repository.findAll();
		model.addAttribute("lista", lista);
		return "motocicletas.html";
	}

	@PostMapping
	public String setMotos(@ModelAttribute(name = "nombre")String nombre, Model model) {
		
		LOG.info("Nombre = "+nombre);
		List<Motocicleta> lista = repository.findAll();
		model.addAttribute("lista", lista);
		return "motocicletas.html";
	}

}
