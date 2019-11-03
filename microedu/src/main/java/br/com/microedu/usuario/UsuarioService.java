package br.com.microedu.usuario;

import java.util.List;

import br.com.microedu.entidade.Usuario;

public interface UsuarioService {

	Usuario salvar(UsuarioModel model);

	List<Usuario> buscarTodos();

	UsuarioModel buscarUsuarioModel(Integer id); 
	
	void deletar(Integer id);

}
