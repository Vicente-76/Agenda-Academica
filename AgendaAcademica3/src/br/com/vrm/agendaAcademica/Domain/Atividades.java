package br.com.vrm.agendaAcademica.Domain;

import java.math.BigDecimal;
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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "atividades")
@NamedQueries({ 
	@NamedQuery(name = "Atividades.consultar", query = "SELECT atividades FROM Atividades atividades"),
	@NamedQuery(name = "Atividades.consultarPorCodigo", query = "SELECT atividades FROM Atividades atividades WHERE codAtividade = :codigo") })
public class Atividades {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codatividade")
	private int codAtividade;

	@NotEmpty(message = "O campo Nome da Atividade é obrigatório")
	@Column(name = "nomeatividade", length = 100, nullable = false)
	private String nomeAtividade;

	@NotNull(message = "O campo Disciplina é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coddisciplina", referencedColumnName = "coddisciplina")
	private Disciplinas disciplinas;

	@NotNull(message = "O campo Tipo de Atividade é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codtipoatividade", referencedColumnName = "codtipoatividade")
	private TiposAtividades tipoAtividades;

	@NotNull(message = "O campo Data é obrigatório")
	@Temporal(value=TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Date data;

	@NotNull(message = "O campo Hora é obrigatório")
	@Temporal(value=TemporalType.TIME)
	@Column(name = "hora", nullable = false)
	private Date hora;

	@NotEmpty(message = "O campo Entregue é obrigatório")
	@Column(name = "entregue", length = 1, nullable = false)
	private String entregue;

	@DecimalMin(value ="0.0", message = "Informe um valor igual ou maior que zero para o campo Média")
	@DecimalMax(value ="10.00", message = "Informe um valor menor ou igual a dez para o campo Média")
	@Column(name = "nota", scale = 2, precision = 4, nullable = true)
	private BigDecimal nota;

	public int getCodAtividade() {
		return codAtividade;
	}

	public void setCodAtividade(int codAtividade) {
		this.codAtividade = codAtividade;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public Disciplinas getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}

	public TiposAtividades getTipoAtividades() {
		return tipoAtividades;
	}

	public void setTipoAtividades(TiposAtividades tipoAtividades) {
		this.tipoAtividades = tipoAtividades;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getEntregue() {
		return entregue;
	}

	public void setEntregue(String entregue) {
		this.entregue = entregue;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Atividades [codAtividade=" + codAtividade + ", nomeAtividade=" + nomeAtividade + ", disciplinas="
				+ disciplinas + ", tipoAtividades=" + tipoAtividades + ", data=" + data + ", hora=" + hora
				+ ", entregue=" + entregue + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codAtividade;
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
		Atividades other = (Atividades) obj;
		if (codAtividade != other.codAtividade)
			return false;
		return true;
	}

	
}
