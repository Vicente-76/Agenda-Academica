package br.com.vrm.agendaAcademica.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vrm.agendaAcademica.DAO.AtividadesDAO;
import br.com.vrm.agendaAcademica.DAO.DisciplinasDAO;
import br.com.vrm.agendaAcademica.DAO.TiposAtividadesDAO;
import br.com.vrm.agendaAcademica.Domain.Atividades;
import br.com.vrm.agendaAcademica.Domain.Disciplinas;
import br.com.vrm.agendaAcademica.Domain.TiposAtividades;
import br.com.vrm.agendaAcademica.Util.FacesUtil;

@ManagedBean
@ViewScoped
public class AtividadeBean {
	private Atividades atividadeCadastro;

	public Atividades getAtividadeCadastro() {
		return atividadeCadastro;
	}

	public void setAtividadeCadastro(Atividades atividadeCadastro) {
		this.atividadeCadastro = atividadeCadastro;
	}

	private List<Atividades> listaAtividade;

	public List<Atividades> getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(List<Atividades> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}

	private List<Atividades> listaAtividadeFiltrada;

	public List<Atividades> getListaAtividadeFiltrada() {
		return listaAtividadeFiltrada;
	}

	public void setListaAtividadeFiltrada(List<Atividades> listaAtividadeFiltrada) {
		this.listaAtividadeFiltrada = listaAtividadeFiltrada;
	}

	private List<Disciplinas> listaDisciplinas;

	public List<Disciplinas> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplinas> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
	
	private List<TiposAtividades> listatipoAtividade;

	public List<TiposAtividades> getListatipoAtividade() {
		return listatipoAtividade;
	}
	
	public void setListatipoAtividade(List<TiposAtividades> listatipoAtividade) {
		this.listatipoAtividade = listatipoAtividade;
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
		atividadeCadastro = new Atividades();
	}
	
	public void salvar() {
		try {
			AtividadesDAO atDAO = new AtividadesDAO();
			atDAO.salvar(atividadeCadastro);
			atividadeCadastro = new Atividades();
			FacesUtil.addMsgInfo("Atividade salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar incluir uma Atividade: " + e.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			AtividadesDAO atDAO = new AtividadesDAO();
			listaAtividade = atDAO.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao listar as Atividades: " + e.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				AtividadesDAO atDAO = new AtividadesDAO();
				atividadeCadastro = atDAO.listarPorCodigo(codigo);
			} else {
				atividadeCadastro = new Atividades();
			}
			
			DisciplinasDAO dDAO = new DisciplinasDAO();
			listaDisciplinas = dDAO.listar();
			
			TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
			listatipoAtividade = tDAO.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu ao tentar erro ao carregar a Atividade: " + e.getMessage());
		}
	}

	public void excluir() {
		try {
			AtividadesDAO atDAO = new AtividadesDAO();
			atDAO.excluir(atividadeCadastro);

			FacesUtil.addMsgInfo("Atividade excluida com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar excluir a Atividade: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			AtividadesDAO atDAO = new AtividadesDAO();
			atDAO.alterar(atividadeCadastro);

			FacesUtil.addMsgInfo("Atividade alterada com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar alterar a Atividade: " + e.getMessage());
		}
	}
}
