package com.sms.agencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.agencia.dataMotocicletas.Motocicleta;
import com.sms.agencia.dataMotocicletas.MotocicletaRepository;

@Controller
@RequestMapping("/motocicletas")
public class MotoController {
	
	@Autowired
	private MotocicletaRepository repository;

	@GetMapping
	public String getListadoMotos(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		List<Motocicleta> lista = repository.findAll();
		model.addAttribute("lista", lista);
		
		return "motocicletas.html";
	}
	
	@PostMapping
	public String setMotos(Model model) {
		List<Motocicleta> lista = repository.findAll();
		lista.add(new Motocicleta("aaa", "aaa", "aaa", 0, 0, 0));
		model.addAttribute("lista", lista);
		
		
		
		return "motocicletas.html";
	}

}

