package com.sms.agencia;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebErrorController implements ErrorController {
	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@GetMapping("/error")
	public String manejarError(HttpServletRequest request, Model model) {
		int codigoError = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		LOG.info((String.valueOf(codigoError)));
		
		
		model.addAttribute("codigoError", codigoError);
		return "error.html";
	}

}
