package br.com.microedu.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microedu.entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
