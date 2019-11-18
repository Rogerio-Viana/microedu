package br.com.microedu.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microedu.entidade.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
