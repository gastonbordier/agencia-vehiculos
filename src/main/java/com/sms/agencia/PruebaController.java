package com.sms.agencia;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.agencia.entidades.Persona;

@Controller
@RequestMapping("/prueba")
public class PruebaController {

	private static final Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@GetMapping
	public String getPrueba(Model model) {
		model.addAttribute("persona", new Persona());
		model.addAttribute("numero", 2);
		
		return "prueba.html";
	}

	@PostMapping("/agregar")
	public String obtenerPersona(@Valid @ModelAttribute(name = "persona") Persona persona, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<ObjectError> lista = result.getAllErrors();
			for (ObjectError objectError : lista) {
				LOG.info(objectError.getDefaultMessage().toString());
			}
		} else {

			LOG.info(persona.toString());
		}

		return "prueba.html";
	}

}
