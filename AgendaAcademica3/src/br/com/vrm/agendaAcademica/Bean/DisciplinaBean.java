package br.com.vrm.agendaAcademica.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vrm.agendaAcademica.DAO.DisciplinasDAO;
import br.com.vrm.agendaAcademica.Domain.Disciplinas;
import br.com.vrm.agendaAcademica.Util.FacesUtil;

@ManagedBean
@ViewScoped
public class DisciplinaBean {
	private Disciplinas disciplinaCadastro;
	
	public Disciplinas getDisciplinaCadastro() {
		return disciplinaCadastro;
	}
	
	public void setDisciplinaCadastro(Disciplinas disciplinaCadastro) {
		this.disciplinaCadastro = disciplinaCadastro;
	}
	
	private List<Disciplinas> listaDisciplina;
		
	public List<Disciplinas> getlistaDisciplina() {
		return listaDisciplina;
	}

	public void setLista(List<Disciplinas> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}
	
	private List<Disciplinas> listaDisciplinasFiltradas;

	public List<Disciplinas> getListaDiciplinasFiltradas() {
		return listaDisciplinasFiltradas;
	}

	public void setListaDisciplinasFiltradas(List<Disciplinas> listaDisciplinasFiltradas) {
		this.listaDisciplinasFiltradas = listaDisciplinasFiltradas;
	}

	private String acao;

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	private Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void novo() {
		disciplinaCadastro = new Disciplinas();
	}
	
	public void salvar() {
		
		try {
			DisciplinasDAO dDAO = new DisciplinasDAO();
			dDAO.salvar(disciplinaCadastro);
			disciplinaCadastro = new Disciplinas();
			FacesUtil.addMsgInfo("Disciplina salva com sucesso");
		}catch (Exception e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar incluir a Disciplina: " + e.getMessage());
		}
	}

	public void carregarPesquisa(){
		try {
			DisciplinasDAO dDAO = new DisciplinasDAO();
			listaDisciplina = dDAO.listar();
		}catch(RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao listar as Disciplinas: " + e.getMessage());
			
		}
	}
	public void carregarCadastro() {
		try {
			if (codigo != null) {
				DisciplinasDAO dDAO = new DisciplinasDAO();
				disciplinaCadastro = dDAO.listarPorCodigo(codigo);
			} else {
				disciplinaCadastro = new Disciplinas();
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu ao tentar erro ao carregar a Disciplina: " + e.getMessage());
		}
	}
	public void excluir() {
		try {
			DisciplinasDAO dDAO = new DisciplinasDAO();
			dDAO.excluir(disciplinaCadastro);

			FacesUtil.addMsgInfo("Disciplina excluida com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar excluir a Disciplina: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			DisciplinasDAO dDAO = new DisciplinasDAO();
			dDAO.alterar(disciplinaCadastro);

			FacesUtil.addMsgInfo("Disciplina alterada com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar alterar a Disciplina: " + e.getMessage());
		}
	}
}
