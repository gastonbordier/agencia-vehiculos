package com.sms.agencia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.agencia.repositories.VehiculoRepository;
import com.sms.agencia.servicios.VehiculoService;

@Controller
public class HomeController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	VehiculoService service;

	@GetMapping("/")
	public String greeting(Model model) {
		int cantidadAutos = service.listar().size();
		
		
		int[] numerosRandom = new int[3];
		for (int i = 0; i < numerosRandom.length; i++) {
			numerosRandom[i] = (int) (Math.random() * (cantidadAutos));
			LOG.info(String.valueOf(numerosRandom[i]));
			model.addAttribute("id["+i+"]", numerosRandom[i]);
			model.addAttribute("auto["+i+"]", service.encontrarPorId(numerosRandom[i]));
		}
		
		
		
		return "home.html";
	}

}
