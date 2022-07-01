package com.sms.agencia;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.agencia.entidades.Vehiculo;
import com.sms.agencia.repositories.VehiculoRepository;
import com.sms.agencia.servicios.VehiculoService;

@Controller
public class HomeController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	VehiculoService service;

	@GetMapping("/")
	public String greeting(Model model) {
		List<Vehiculo> lista = service.listarTresVehiculosAleatorios();
		model.addAttribute("lista", lista);

		return "home.html";
	}

}
