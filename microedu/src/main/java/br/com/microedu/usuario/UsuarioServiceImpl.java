package br.com.microedu.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microedu.entidade.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Usuario salvar(UsuarioModel model) {
		Usuario usuario = new Usuario();

		if (model.getId() != null) {
			usuario.setId(model.getId());
		}

		usuario.setEmail(model.getEmail());
		usuario.setNome(model.getNome());
		usuario.setSenha(model.getSenha());
		usuario.setTipoUsuario(model.getTipoUsuario());
		usuario.setAtivo(true);

		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public void deletar(Integer id) {
		if (id != null) {
			Usuario usuario = usuarioRepository.findAll().get(0);
			usuario.setAtivo(false);
			usuarioRepository.save(usuario);
		}
	}

	@Override
	public UsuarioModel buscarUsuarioModel(Integer id) {
		return converteParaModel(new UsuarioModel(), usuarioRepository.findById(id).get());
	}

	private UsuarioModel converteParaModel(UsuarioModel usuarioModel, Usuario usuario) {

		usuarioModel.setId(usuario.getId());
		usuarioModel.setEmail(usuario.getEmail());
		usuarioModel.setNome(usuario.getNome());
		usuarioModel.setSenha(usuario.getSenha());
		usuarioModel.setTipoUsuario(usuario.getTipoUsuario());

		return usuarioModel;
	}

}
