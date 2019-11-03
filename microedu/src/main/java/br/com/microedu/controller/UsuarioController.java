package br.com.microedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.microedu.freemarker.IndexOfMethod;
import br.com.microedu.usuario.UsuarioModel;
import br.com.microedu.usuario.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView buscar() {
		return new ModelAndView("pages/listagem-usuario")
				.addObject("usuarios", usuarioService.buscarTodos())
				.addObject("indexOf", new IndexOfMethod());
	}

	@RequestMapping(value = { "/", "{id}" }, method = RequestMethod.GET)
	public ModelAndView criar(@PathVariable("id") Integer id) {
		return new ModelAndView("pages/edicao-usuario").addObject("usuarios", usuarioService.buscarUsuarioModel(id));
	}

	@RequestMapping(value = { "/", "/save" }, method = RequestMethod.GET)
	public String salvar(@ModelAttribute UsuarioModel model) {
		usuarioService.salvar(model);
		return (model.getId() == null ? HttpStatus.CREATED.name() : HttpStatus.UPGRADE_REQUIRED.name());
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String deletar(@PathVariable("id") Integer id) {
		usuarioService.deletar(id);
		return "Dados deletados!.";
	}

}
