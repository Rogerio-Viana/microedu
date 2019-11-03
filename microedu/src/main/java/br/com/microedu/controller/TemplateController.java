package br.com.microedu.controller;

import org.springframework.web.servlet.ModelAndView;

import br.com.microedu.freemarker.IndexOfMethod;

public class TemplateController {

	public ModelAndView getTemplate(String page) {
		return new ModelAndView(page)
				.addObject("indexOf", new IndexOfMethod());
	}
}
