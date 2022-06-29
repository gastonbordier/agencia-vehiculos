package com.sms.agencia;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sms.agencia.entidades.Motocicleta;
import com.sms.agencia.repositories.MotocicletaRepository;
import com.sms.agencia.servicios.MotocicletaService;
import com.sms.agencia.servicios.VehiculoService;

@Controller
public class GaleriaController {

	private static Logger LOG = LoggerFactory.getLogger(AgenciaApplication.class);

	@Autowired
	private VehiculoService service;

	@GetMapping("/galeria")
	public String getGaleria(Model model) {
//		service.listar().forEach(obj -> LOG.info(obj.toString()));
		model.addAttribute("lista", service.listar());

		return "galeria.html";
	}

	@GetMapping("/imagenes/{id}")
	public void imagenes(@PathVariable String id, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg");
		InputStream inputStream = new ByteArrayInputStream(service.encontrarPorId(Integer.valueOf(id)).getImagen());
		IOUtils.copy(inputStream, response.getOutputStream());

	}

//	@GetMapping("/image")
//	@ResponseBody
//	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<ImageGallery> imageGallery)
//			throws ServletException, IOException {
//		imageGallery = imageGalleryService.getImageById(id);
//		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//		response.getOutputStream().write(imageGallery.get().getImage());
//		response.getOutputStream().close();
//		LOG.info("Id :: " + id);
//	}

}
