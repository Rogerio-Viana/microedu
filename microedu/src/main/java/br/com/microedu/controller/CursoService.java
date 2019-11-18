package br.com.microedu.controller;

import java.util.List;

import br.com.microedu.entidade.Curso;

public interface CursoService {

	void apagar(Integer id);

	List<Curso> listar();

	void salvar(Curso curso);

	Curso buscarCurso(Integer id);

}
