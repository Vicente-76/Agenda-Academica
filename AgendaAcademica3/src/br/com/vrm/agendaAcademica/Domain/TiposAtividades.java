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
@Table(name = "tiposatividades")
@NamedQueries({
		@NamedQuery(name = "TiposAtividades.consultar", query = "SELECT tiposAtividades FROM TiposAtividades tiposAtividades"),
		@NamedQuery(name = "TiposAtividades.consultarPorCodigo", query = "SELECT tiposAtividades FROM TiposAtividades tiposAtividades WHERE codTipoAtividade = :codigo") })
public class TiposAtividades {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codtipoatividade")
	private int codTipoAtividade;

	@NotEmpty(message = "O campo Nome do Tipo de Atividade é obrigatório")
	@Size(min = 4, max = 100, message = "Tamanho inválido para o campo Nome do Tipo de Atividade (4 - 100)")
	@Column(name = "nometipoatividade", length = 100, nullable = false)
	private String nomeTipoAtividade;

	public int getCodTipoAtividade() {
		return codTipoAtividade;
	}

	public void setCodTipoAtividade(int codigo) {
		codTipoAtividade = codigo;
	}

	public String getNomeTipoAtividade() {
		return nomeTipoAtividade;
	}

	public void setNomeTipoAtividade(String nomeTipoAtividade) {
		this.nomeTipoAtividade = nomeTipoAtividade;
	}

	@Override
	public String toString() {
		return "TipoAtividade [codTipoAtividade=" + codTipoAtividade + ", nomeTipoAtividade=" + nomeTipoAtividade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codTipoAtividade;
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
		TiposAtividades other = (TiposAtividades) obj;
		if (codTipoAtividade != other.codTipoAtividade)
			return false;
		return true;
	}

}
