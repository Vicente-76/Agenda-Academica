package br.com.vrm.agendaAcademica.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
@NamedQueries({ 
	@NamedQuery(name = "Usuarios.consultar", query = "SELECT usuarios FROM Usuarios usuarios"),
	@NamedQuery(name = "Usuarios.consultarPorCodigo", query = "SELECT usuarios FROM Usuarios usuarios WHERE codUsuario = :codigo") })
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codusuario")
	private int codUsuario;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Size(min = 4, max = 100, message = "Tamanho inválido para o campo nome (4 - 100)")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@NotEmpty(message = "O campo senha é obrigatório")
	@Size(min = 6, max = 20, message = "Tamanho inválido para o campo senha (6 - 8)")
	@Column(name = "senha", length = 32, nullable = false)
	private String senha;

	@NotEmpty(message = "O campo curso é obrigatório")
	@Size(min = 3, max = 50, message = "Tamanho inválido para o campo curso (3 - 50)")
	@Column(name = "curso", length = 50, nullable = false)
	private String curso;

	@NotEmpty(message = "O campo instituição é obrigatório")
	@Size(min = 5, max = 100, message = "Tamanho inválido para o campo instituição (5 - 100)")
	@Column(name = "instituicao", length = 100, nullable = false)
	private String instituicao;

	@NotEmpty(message = "O campo cidade é obrigatório")
	@Size(min = 5, max = 100, message = "Tamanho inválido para o campo senha (5 - 100)")
	@Column(name = "cidade", length = 100, nullable = false)
	private String cidade;

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nome=" + nome + ", senha=" + senha + ", curso=" + curso
				+ ", instituicao=" + instituicao + ", cidade=" + cidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (codUsuario != other.codUsuario)
			return false;
		return true;
	}

}
