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
import com.sms.agencia.entidades.Sedan;
import com.sms.agencia.servicios.CamionetaService;
import com.sms.agencia.servicios.SedanService;

@ControllerAdvice
@RequestMapping("/sedanes")
public class SedanController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private SedanService sedanService;

	private boolean panelEditarEliminarActivo = false;
	private boolean panelAgregarActivo = false;

	@GetMapping
	public String getListadoSedanes(Model model) {
		panelEditarEliminarActivo = false;
		panelAgregarActivo = false;

		actualizarModelo(model);
		return "sedanes.html";
	}

	@PostMapping("/obtener-por-id")
	public String obtenerPorId(@ModelAttribute(name = "idBuscar") String idBuscar, Model model) {
		LOG.info("id = " + idBuscar);
		LOG.info(String.valueOf(idBuscar));
		int valorId = -1;

		try {
			valorId = Integer.parseInt(idBuscar);

			if (sedanService.existeId(valorId)) {

				Sedan sedanEditable = sedanService.encontrarPorId(valorId);
				LOG.info(sedanEditable.toString());
				panelEditarEliminarActivo = true;
				panelAgregarActivo = false;
				model.addAttribute("idBuscar", idBuscar);
				model.addAttribute("sedanEditable", sedanEditable);
			} else {
				model.addAttribute("hayErrores", true);
				model.addAttribute("listaMensajesError", "El id no existe.");

			}
		} catch (NumberFormatException e) {
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", "El id debe ser un numero.");

		}

		actualizarModelo(model);
		return "sedanes.html";
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=editar")
	public String editar(@Valid @ModelAttribute Sedan sedanEditable, BindingResult result, Model model) {
		if (result.hasErrors()) {

			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", obtenerMensajesError(result));
			sedanEditable = sedanService.encontrarPorId(sedanEditable.getId());
			model.addAttribute("sedanEditable", sedanEditable);

		} else {
			sedanService.grabar(sedanEditable);
			model.addAttribute("hayOperacion", true);
			model.addAttribute("mensajeOperacion", "Sedan editado");
			panelEditarEliminarActivo = false;
		}

		actualizarModelo(model);
		return "sedanes.html";
	}

	@PostMapping(path = "/editar-eliminar", params = "accion=eliminar")
	public String eliminarSedan(@ModelAttribute(name = "id") String id, Model model) {
		sedanService.eliminarPorId(Integer.parseInt(id));
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		model.addAttribute("hayOperacion", true);
		model.addAttribute("mensajeOperacion", "Sedan eliminado");
		actualizarModelo(model);
		return "sedanes.html";
	}

	@PostMapping("/activar-panel-agregar")
	public String activarPanelAgregar(Model model) {
		panelAgregarActivo = true;
		panelEditarEliminarActivo = false;
		model.addAttribute("sedanNuevo", new Sedan());
		actualizarModelo(model);
		return "sedanes.html";
	}

	@PostMapping("/agregar")
	public String agregar(@Valid @ModelAttribute Sedan sedanNuevo, BindingResult result, Model model) {

		if (result.hasErrors()) {
			LOG.info(String.valueOf(sedanNuevo.getCapacidadOcupantes()));
			model.addAttribute("sedanNuevo", sedanNuevo);
			model.addAttribute("hayErrores", true);
			model.addAttribute("listaMensajesError", obtenerMensajesError(result));

		} else {
			sedanService.grabar(sedanNuevo);
			panelAgregarActivo = false;
			panelEditarEliminarActivo = false;
			model.addAttribute("hayOperacion", true);
			model.addAttribute("mensajeOperacion", "Sedan agregado");

		}

		actualizarModelo(model);
		return "sedanes.html";
	}

	@PostMapping("/cancelar")
	public String cancelar(Model model) {
		panelAgregarActivo = false;
		panelEditarEliminarActivo = false;

		actualizarModelo(model);
		return "sedanes.html";
	}

	private void actualizarModelo(Model model) {
//		actualiza lista 
		List<Sedan> lista = sedanService.listar();
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
