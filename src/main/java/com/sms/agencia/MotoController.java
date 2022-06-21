package com.sms.agencia;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.repositories.MotocicletaRepository;
import com.sms.agencia.servicios.MotocicletaServiceImpl;

@ControllerAdvice
@RequestMapping("/motocicletas")
public class MotoController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private MotocicletaServiceImpl motocicletaService;

	private boolean panelEditarEliminarActivo = false;
	private boolean panelAgregarActivo = false;
	private String mensajeRespuesta = "";

	@GetMapping
	public String getListadoMotos(Model model) {
		panelEditarEliminarActivo = false;
		panelAgregarActivo = false;

		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/obtener-por-id")
	public String obtenerPorId(@ModelAttribute(name = "idBuscar") String idBuscar, Model model) {
		LOG.info("id = " + idBuscar);

		if (idBuscar.length() > 0) {

			Motocicleta motocicletaEditable = motocicletaService.findById(Integer.parseInt(idBuscar));
			LOG.info(motocicletaEditable.toString());
			panelEditarEliminarActivo = true;
			panelAgregarActivo = false;

			model.addAttribute("motocicletaEditable", motocicletaEditable);

		}
		actualizarModelo(model);
		return "motocicletas.html";
	}

	@ExceptionHandler(NumberFormatException.class)
	public void excepcionNumero() {

	}

	@PostMapping(path = "/editar-eliminar", params = "accion=editar")
	public String editar(@Valid @ModelAttribute Motocicleta motocicletaEditable, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("hayErrores", true);

			List<ObjectError> list = new ArrayList<>();
			result.getAllErrors().forEach(obj -> list.add(obj));

//			for(int i = 0; i < list.size(); i++) {
//				if( list.get(i).getCode().equals("typeMismatch")) {
//					model.addAttribute("error"+i, );
//				}else {
//					
//					model.addAttribute("error"+i, list.get(i).getDefaultMessage() );
//				}
//			}
//			

			list.forEach(error -> {
//				LOG.info(error.getDefaultMessage());
				
				LOG.info(error.getCodes()[0]);
//				LOG.info(error.getCodes()[0].split(".")[2]);
//				LOG.info(String.valueOf(error.getArguments().length));
//				for (String code : error.getCodes()) {
//					LOG.info(code.split(".")[2]);
//
//				}

			});
			model.addAttribute("motocicletaEditable", motocicletaEditable);
			actualizarModelo(model);

			return "motocicletas.html";
		} else {
			motocicletaService.save(motocicletaEditable);
			panelAgregarActivo = false;
			panelEditarEliminarActivo = false;
			actualizarModelo(model);
			return "motocicletas.html";
		}
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=eliminar")
	public String eliminar(@ModelAttribute(name = "id") String id, Model model) {
		motocicletaService.deleteById(Integer.parseInt(id));
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/agregar")
	public String agregarMoto(Model model) {
		try {

			panelAgregarActivo = true;
			panelEditarEliminarActivo = false;

			actualizarModelo(model);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "motocicletas.html";
	}

	@PostMapping("/chequear-agregar")
	public String chequearAgregarMoto(@ModelAttribute Motocicleta motocicletaNueva, BindingResult result, Model model) {

		if (result.getAllErrors().size() == 0) {
			motocicletaService.save(motocicletaNueva);
			panelAgregarActivo = false;
			panelEditarEliminarActivo = false;

		} else {
			for (ObjectError error : result.getAllErrors()) {
				LOG.info("ITEM " + error.getCodes()[2]);
				model.addAttribute("motocicletaNueva", motocicletaNueva);

			}

		}

		actualizarModelo(model);
		return "motocicletas.html";
	}
//
//	@ExceptionHandler(value = BindException.class)
//	public String manejarExcepciones(Model model) {
//		return "motocicletas.html";
//	}

	@PostMapping("/cancelar")
	public String cancelar(Model model) {
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		actualizarModelo(model);
		return "motocicletas.html";
	}

	private void actualizarModelo(Model model) {
//		actualiza lista 
		List<Motocicleta> lista = motocicletaService.findAll();
		model.addAttribute("lista", lista);
//		actualiza modo de display
		model.addAttribute("panelEditarEliminar", panelEditarEliminarActivo);
		model.addAttribute("panelAgregar", panelAgregarActivo);
	}

}
