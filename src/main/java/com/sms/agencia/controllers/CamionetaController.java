package com.sms.agencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CamionetaController {

	@GetMapping("/camionetas")
	public String getTemplateCamionetas(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		return "camionetas.html";
	}

}

