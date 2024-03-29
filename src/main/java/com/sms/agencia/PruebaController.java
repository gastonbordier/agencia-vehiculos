package com.sms.agencia;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sms.agencia.entidades.Camioneta;
import com.sms.agencia.entidades.Persona;
import com.sms.agencia.repositories.CamionetaRepository;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

	private static final Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private CamionetaRepository repository;
	
	
	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "Esta todo mal")
	public String getPrueba() {
		return "prueba.html";
	}

	
	
	@GetMapping("/json-camionetas")
	public ResponseEntity<Camioneta[]> getPersona(Model model) {
		List<Camioneta> listaCamionetas = repository.findAll();
		Camioneta[] arrayCamionetas = listaCamionetas.toArray(new Camioneta[listaCamionetas.size()]);
		return new ResponseEntity<>(arrayCamionetas,HttpStatus.OK);
	}
	


}
