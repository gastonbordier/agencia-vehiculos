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
import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.servicios.MotocicletaServiceImpl;

@ControllerAdvice
@RequestMapping("/motocicletas")
public class MotoController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private MotocicletaServiceImpl motocicletaService;

	private boolean panelEditarEliminarActivo = false;
	private boolean panelAgregarActivo = false;
	
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
		LOG.info(String.valueOf(idBuscar));
		int valorId = -1;

		try {
			valorId = Integer.parseInt(idBuscar);

			if (motocicletaService.existeId(valorId)) {

				Motocicleta motocicletaEditable = motocicletaService.encontrarPorId(valorId);
				LOG.info(motocicletaEditable.toString());
				panelEditarEliminarActivo = true;
				panelAgregarActivo = false;
				model.addAttribute("idBuscar", idBuscar);
				model.addAttribute("motocicletaEditable", motocicletaEditable);
			} else {
				model.addAttribute("hayErrores", true);
				model.addAttribute("listaMensajesError", "El id no existe.");

			}
		} catch (NumberFormatException e) {
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", "El id debe ser un numero.");

		}

		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=editar")
	public String editar(@Valid @ModelAttribute Motocicleta motocicletaEditable, BindingResult result, Model model) {
		if (result.hasErrors()) {

			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", obtenerMensajesError(result));
			motocicletaEditable = motocicletaService.encontrarPorId(motocicletaEditable.getId());

		} else {
			motocicletaService.grabar(motocicletaEditable);
			model.addAttribute("hayOperacion", true);
			model.addAttribute("mensajeOperacion", "Motocicleta editada");
			panelEditarEliminarActivo = false;
		}

		model.addAttribute("motocicletaEditable", motocicletaEditable);
		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=eliminar")
	public String eliminarMotocicleta(@ModelAttribute(name = "id") String id, Model model) {
		motocicletaService.eliminarPorId(Integer.parseInt(id));
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		model.addAttribute("hayOperacion", true);
		model.addAttribute("mensajeOperacion", "Motocicleta eliminada");
		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/activar-panel-agregar")
	public String activarPanelAgregar(Model model) {
		panelAgregarActivo = true;
		panelEditarEliminarActivo = false;
		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/agregar")
	public String agregar(@Valid @ModelAttribute Motocicleta motocicletaNueva, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", obtenerMensajesError(result));

		} else {
			motocicletaService.grabar(motocicletaNueva);
			panelAgregarActivo = false;
			panelEditarEliminarActivo = false;
			model.addAttribute("hayOperacion", true);
			model.addAttribute("mensajeOperacion", "Motocicleta agregada");

		}

		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/cancelar")
	public String cancelar(Model model) {
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		actualizarModelo(model);
		return "motocicletas.html";
	}

	private void actualizarModelo(Model model) {
//		actualiza lista 
		List<Motocicleta> lista = motocicletaService.listar();
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
