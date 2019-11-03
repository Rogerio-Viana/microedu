package br.com.microedu.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.microedu.enums.EnumTipoUsuario;

@Entity
public class Usuario {

	@Id
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Integer id;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String senha;

	@Column
	@Enumerated(EnumType.STRING)
	private EnumTipoUsuario tipoUsuario;

	@Column
	private Boolean ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public EnumTipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(EnumTipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
