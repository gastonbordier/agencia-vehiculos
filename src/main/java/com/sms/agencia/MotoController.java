package com.sms.agencia;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.agencia.dataMotocicletas.Motocicleta;
import com.sms.agencia.dataMotocicletas.MotocicletaRepository;

@Controller
@RequestMapping("/motocicletas")
public class MotoController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private MotocicletaRepository repository;

	private boolean editarMotocicleta = false;
	private boolean agregarMotocicleta = false;

	@GetMapping
	public String getListadoMotos(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		editarMotocicleta = false;
		agregarMotocicleta = false;

		model.addAttribute("edit", editarMotocicleta);
		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/editar-eliminar")
	public String obtenerPorId(@ModelAttribute(name = "id") String id, Model model) {

		if (id.length() > 0) {

			LOG.info("Nombre = " + id);
			Motocicleta motocicletaEditable = repository.findById(Integer.parseInt(id));
			LOG.info(motocicletaEditable.toString());
			editarMotocicleta = true;
			agregarMotocicleta = false;

			model.addAttribute("marca", motocicletaEditable.getMarca());
			model.addAttribute("modelo", motocicletaEditable.getModelo());
			model.addAttribute("color", motocicletaEditable.getColor());
			model.addAttribute("stock", motocicletaEditable.getStock());
			model.addAttribute("precio", motocicletaEditable.getPrecio());
			model.addAttribute("cilindrada", motocicletaEditable.getCilindrada());

		}
		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("/agregar")
	public String agregarMoto(Model model) {
		agregarMotocicleta = true;
		editarMotocicleta = false;

		actualizarModelo(model);
		return "motocicletas.html";
	}

	@PostMapping("motocicletas/editar-eliminar/cancelar")
	public String cancelar(Model model) {
		agregarMotocicleta = false;
		editarMotocicleta = false;

		actualizarModelo(model);
		return "motocicletas.html";
	}

	private void actualizarModelo(Model model) {
//		actualiza lista 
		List<Motocicleta> lista = repository.findAll();
		model.addAttribute("lista", lista);
//		actualiza modo de display
		model.addAttribute("editarMotocicleta", editarMotocicleta);
		model.addAttribute("agregarMotocicleta", agregarMotocicleta);
	}

}
