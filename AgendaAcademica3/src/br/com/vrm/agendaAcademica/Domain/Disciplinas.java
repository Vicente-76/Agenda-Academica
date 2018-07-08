package br.com.vrm.agendaAcademica.Domain;

import java.math.BigDecimal;

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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "disciplinas")
@NamedQueries({
	@NamedQuery(name = "Disciplinas.consultar", query = "SELECT disciplinas FROM Disciplinas disciplinas"),
	@NamedQuery(name = "Disciplinas.consultarPorCodigo", query = "SELECT disciplinas FROM Disciplinas disciplinas WHERE codDisciplinas = :codigo") })
public class Disciplinas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coddisciplina")
	private int codDisciplina;

	@NotEmpty(message = "O campo Nome da Disciplina é obrigatório")
	@Size(min = 3, max = 100, message = "Tamanho inválido para o campo Nome da Disciplina (3 - 100)")
	@Column(name = "nomedisciplina", length = 100, nullable = false)
	private String nomeDisciplina;
	
	@NotEmpty(message = "O campo Nome do Professor é obrigatório")
	@Size(min = 4, max = 100, message = "Tamanho inválido para o campo Nome do Professor (5 - 100)")
	@Column(name = "nomeprofessor", length = 100, nullable = false)
	private String nomeProf;

	@Size(min = 10, max = 100, message = "Tamanho inválido para o campo Email do professor (10 - 100)")
	@Column(name = "emailprofessor", length = 100, nullable = true)
	private String emailProf;

	@NotNull(message = "O campo Carga Horária é obrigatório")
	@Min(value=1, message = "Informe um valor maior ou igual a um para o campo Carga Horária")
	@Max(value=99, message = "Informe um valor menor que cem para o campo Carga Horária")
	@Column(name = "cargahoraria", length = 5, nullable = false)
	private int cargaHoraria;

	@Size(min = 10, max = 50, message = "Tamanho inválido para o campo Método de Avaliação (10 - 100)")
	@Column(name = "metodoavaliacao", length = 50, nullable = true)
	private String metodoAvaliacao;
	
	@NotNull(message = "O campo Semestre é obrigatório")
	@Min(value=1, message = "Informe um valor maior ou igual a um para o campo Semestre")
	@Max(value=10, message = "Informe um valor menor igual a dez para o campo Semestre")
	@Column(name = "semestre", nullable = false)
	private int semestre;

	@NotNull(message = "O campo Média é obrigatório")
	@DecimalMin(value ="0.0", message = "Informe um valor igual ou maior que zero para o campo Média")
	@DecimalMax(value ="9.99", message = "Informe um valor menor que dez para o campo Média")
	@Column(name = "media", scale = 2, precision = 3, nullable = false)
	private BigDecimal media;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codusuario", referencedColumnName = "codusuario")
	private Usuarios usuario;
	
	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeProf() {
		return nomeProf;
	}

	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}

	public String getEmailProf() {
		return emailProf;
	}

	public void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getMetodoAvaliacao() {
		return metodoAvaliacao;
	}

	public void setMetodoAvaliacao(String metodoAvaliacao) {
		this.metodoAvaliacao = metodoAvaliacao;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Disciplina [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", nomeProf="
				+ nomeProf + ", emailProf=" + emailProf + ", cargaHoraria=" + cargaHoraria + ", metodoAvaliacao="
				+ metodoAvaliacao + ", semestre=" + semestre + ", media=" + media + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codDisciplina;
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
		Disciplinas other = (Disciplinas) obj;
		if (codDisciplina != other.codDisciplina)
			return false;
		return true;
	}

}
