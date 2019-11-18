package br.com.microedu.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.microedu.entidade.Curso;

@Controller
@RequestMapping("/curso")
public class CursoController extends TemplateController {

	@Autowired
	private CursoService cursoService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ModelAndView listar() {
		return getTemplate("pages/listagem-curso").addObject("turmas", cursoService.listar());
	}

	@RequestMapping(value = { "/criar", "/criar/{id}" }, method = RequestMethod.GET)
	public ModelAndView criar(@PathParam("id") Integer id) {
		return getTemplate("pages/edicao-curso").addObject("turma", cursoService.buscarCurso(id));
	}

	@RequestMapping(value = { "/criar" }, method = RequestMethod.POST)
	public void salvar(@ModelAttribute Curso curso) {
		cursoService.salvar(curso);
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.POST)
	public void apagar(@PathParam("id") Integer id) {
		cursoService.apagar(id);
	}

}
