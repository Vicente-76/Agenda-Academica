package br.com.vrm.agendaAcademica.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ausencias")
@NamedQueries({ 
	@NamedQuery(name = "Ausencias.consultar", query = "SELECT ausencias FROM Ausencias ausencias"),
	@NamedQuery(name = "Ausencias.consultarPorCodigo", query = "SELECT ausencias FROM Ausencias ausencias WHERE codAusencia = :codigo") })
public class Ausencias {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codausencia")
	private int codAusencia;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="coddisciplina", referencedColumnName="coddisciplina", nullable=false)
	private Disciplinas disciplina;
	
	@NotNull
	@Temporal(value=TemporalType.DATE)
	@Column(name="data", nullable=false)
	private Date data;
	
	@NotNull(message = "O campo Ausencia é obrigatório")
	@Min(value=1, message = "Informe um valor maior ou igual a um para o campo Semestre")
	@Max(value=4, message = "Informe um valor menor ou igual a quatro para o campo Semestre")
	@Column(name="quantidade", nullable=false)
	private int quantidade;

	public int getCodAusencia() {
		return codAusencia;
	}

	public void setCodAusencia(int codAusencia) {
		this.codAusencia = codAusencia;
	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Ausencias [codAusencia=" + codAusencia + ", disciplina=" + disciplina + ", data=" + data
				+ ", quantidade=" + quantidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codAusencia;
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
		Ausencias other = (Ausencias) obj;
		if (codAusencia != other.codAusencia)
			return false;
		return true;
	}
}
