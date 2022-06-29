package com.sms.agencia;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.agencia.entidades.Camioneta;
import com.sms.agencia.servicios.CamionetaService;

@ControllerAdvice
@RequestMapping("/camionetas")
public class CamionetaController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private CamionetaService camionetaService;

	private boolean panelEditarEliminarActivo = false;
	private boolean panelAgregarActivo = false;
	
	@GetMapping
	public String getListadoCamionetas(Model model) {
		panelEditarEliminarActivo = false;
		panelAgregarActivo = false;


		actualizarModelo(model);
		return "camionetas.html";
	}

	@PostMapping("/obtener-por-id")
	public String obtenerPorId(@ModelAttribute(name = "idBuscar") String idBuscar, Model model) {
		LOG.info("id = " + idBuscar);
		LOG.info(String.valueOf(idBuscar));
		int valorId = -1;

		try {
			valorId = Integer.parseInt(idBuscar);

			if (camionetaService.existeId(valorId)) {

				Camioneta camionetaEditable = camionetaService.encontrarPorId(valorId);
				LOG.info(String.format("%f",camionetaEditable.getPrecio()));
				panelEditarEliminarActivo = true;
				panelAgregarActivo = false;
				model.addAttribute("idBuscar", idBuscar);
				model.addAttribute("camionetaEditable", camionetaEditable);
			} else {
				model.addAttribute("hayErrores", true);
				model.addAttribute("listaMensajesError", "El id no existe.");

			}
		} catch (NumberFormatException e) {
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", "El id debe ser un numero.");

		}

		actualizarModelo(model);
		return "camionetas.html";
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=editar")
	public String editar(@Valid @ModelAttribute Camioneta camionetaEditable, BindingResult result, Model model) {
		if (result.hasErrors()) {
			
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", obtenerMensajesError(result));
			camionetaEditable = camionetaService.encontrarPorId(camionetaEditable.getId());
			model.addAttribute("camionetaEditable", camionetaEditable);

		} else {
			camionetaService.grabar(camionetaEditable);
			model.addAttribute("hayOperacion", true);
			model.addAttribute("mensajeOperacion", "Camioneta editada");
			panelEditarEliminarActivo = false;
		}

		actualizarModelo(model);
		return "camionetas.html";
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=eliminar")
	public String eliminarCamioneta(@ModelAttribute(name = "id") String id, Model model) {
		camionetaService.eliminarPorId(Integer.parseInt(id));
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		model.addAttribute("hayOperacion", true);
		model.addAttribute("mensajeOperacion", "Camioneta eliminada");
		actualizarModelo(model);
		return "camionetas.html";
	}

	@PostMapping("/activar-panel-agregar")
	public String activarPanelAgregar(Model model) {
		panelAgregarActivo = true;
		panelEditarEliminarActivo = false;
		model.addAttribute("camionetaNueva", new Camioneta());
		actualizarModelo(model);
		return "camionetas.html";
	}

	@PostMapping("/agregar")
	public String agregar(@Valid @ModelAttribute Camioneta camionetaNueva, BindingResult result, Model model) {

		if (result.hasErrors()) {
			LOG.info(String.valueOf(camionetaNueva.getCapacidadOcupantes()));
			model.addAttribute("camionetaNuevo",camionetaNueva);
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", obtenerMensajesError(result));

		} else {
			camionetaService.grabar(camionetaNueva);
			panelAgregarActivo = false;
			panelEditarEliminarActivo = false;
			model.addAttribute("hayOperacion", true);
			model.addAttribute("mensajeOperacion", "Camioneta agregada");

		}

		actualizarModelo(model);
		return "camionetas.html";
	}

	@PostMapping("/cancelar")
	public String cancelar(Model model) {
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		actualizarModelo(model);
		return "camionetas.html";
	}

	private void actualizarModelo(Model model) {
//		actualiza lista 
		List<Camioneta> lista = camionetaService.listar();
		model.addAttribute("lista", lista);
//		actualiza modo de display
		model.addAttribute("panelEditarEliminar", panelEditarEliminarActivo);
		model.addAttribute("panelAgregar", panelAgregarActivo);
	}

	private List<String> obtenerMensajesError(BindingResult result) {
		List<ObjectError> listaErrores = new ArrayList<>();
		List<String> listaMensajes = new ArrayList<>();

		result.getAllErrors().forEach(error -> listaErrores.add(error));
		listaErrores.forEach(error -> {

			if (error.getCode().equals("typeMismatch")) {
				String campo = error.getCodes()[0].split("\\.")[2];
				listaMensajes.add("El ingreso en " + campo + " debe ser un numero.");
			} else {
				listaMensajes.add(error.getDefaultMessage());
			}

		});

		return listaMensajes;
	}

}
