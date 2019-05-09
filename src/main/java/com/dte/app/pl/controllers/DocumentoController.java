package com.dte.app.pl.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dte.app.bt.IDocumentoDAO;
import com.dte.app.bt.IDocumentoService;
import com.dte.app.dl.entity.Documento;
import com.dte.app.util.Paginador;

@Controller
@SessionAttributes("documento")
public class DocumentoController {

	@Autowired
	private IDocumentoService documentoService;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String listarDocumentos(@RequestParam(name="page",defaultValue="0") int page, Model modelo) {
		 
		Pageable pageRequest = PageRequest.of(page, 2);
		Page<Documento> documentos = documentoService.findAll(pageRequest);
		Paginador<Documento> paginador = new Paginador<>("/",documentos);
		modelo.addAttribute("titulo", "Listado de Documentos");
		modelo.addAttribute("documentos", documentos);
		modelo.addAttribute("page",paginador);
		return "listado";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Map<String,Object> model) {
		
		Documento documento = new Documento();
		model.put("documento", documento);
		model.put("titulo", "Formulario de Documentos");
		
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardarDocumento(Documento documento) {
		documentoService.save(documento);
		return "redirect:/";
	}
	
}
