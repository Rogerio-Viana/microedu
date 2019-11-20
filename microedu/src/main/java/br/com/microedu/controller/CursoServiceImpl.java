package br.com.microedu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microedu.entidade.Curso;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public Boolean apagar(Integer id) {
		if (id != null) {
			Optional<Curso> curso = cursoRepository.findById(id);
			if (curso.isPresent()) {
				cursoRepository.delete(curso.get());
				return true;
			}
		}
		return false;

	}

	@Override
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	@Override
	public void salvar(Curso curso) {
		if (curso.getId() != null) {
			Optional<Curso> ent = cursoRepository.findById(curso.getId());
			if (ent.isPresent()) {
				ent.get().setDescricao(curso.getDescricao());
				ent.get().setEmenta(curso.getEmenta());
				ent.get().setHorario(curso.getHorario());
				ent.get().setNome(curso.getNome());
				ent.get().setProfessor(curso.getProfessor());

				cursoRepository.save(curso);
			}
		}

		cursoRepository.save(curso);
	}

	@Override
	public Curso buscarCurso(Integer id) {
		if (id != null)
			return cursoRepository.findById(id).get();
		return new Curso();

	}

}
