package br.com.siac.pesistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="siac_user")
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "nome_usuario", nullable = false, length = 120)
	private String nomeUsuario;

	@NotEmpty
	@Column(name = "senha", nullable = false, length = 120)
	private String senha;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + getId() + ", username='" + nomeUsuario + '\'' + ", senha='" + senha + '\'' + '}';
	}
}
