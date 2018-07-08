package br.com.vrm.agendaAcademica.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vrm.agendaAcademica.DAO.TiposAtividadesDAO;
import br.com.vrm.agendaAcademica.Domain.TiposAtividades;
import br.com.vrm.agendaAcademica.Util.FacesUtil;

@ManagedBean(name = "tipoAtividadeBean")
@ViewScoped
public class TipoAtividadeBean {
	
	private TiposAtividades tipoAtividadeCadastro;

	public TiposAtividades getTipoAtividadeCadastro() {
		return tipoAtividadeCadastro;
	}

	public void setTipoAtividadeCadastro(TiposAtividades tipoAtividadeCadastro) {
		this.tipoAtividadeCadastro = tipoAtividadeCadastro;
	}

	private List<TiposAtividades> listatipoAtividade;

	public List<TiposAtividades> getListatipoAtividade() {
		return listatipoAtividade;
	}
	
	public void setListatipoAtividade(List<TiposAtividades> listatipoAtividade) {
		this.listatipoAtividade = listatipoAtividade;
	}

	private List<TiposAtividades> listaTipoAtividadeFiltrados;

	public List<TiposAtividades> getListaTipoAtividadeFiltrados() {
		return listaTipoAtividadeFiltrados;
	}

	public void setListaTipoAtividadeFiltrados(List<TiposAtividades> listaTipoAtividadeFiltrados) {
		this.listaTipoAtividadeFiltrados = listaTipoAtividadeFiltrados;
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
		tipoAtividadeCadastro = new TiposAtividades();
	}

	public void salvar() {

		try {
			TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
			tDAO.salvar(tipoAtividadeCadastro);
			tipoAtividadeCadastro = new TiposAtividades();
			FacesUtil.addMsgInfo("Tipo de Atividade salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar incluir um Tipo de Atividade: " + e.getMessage());
		}
	}

	public void carregarPesquisa(){
		try {
			TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
			listatipoAtividade = tDAO.listar();
		}catch(RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao listar os Tipos de Atividades: " + e.getMessage());
			
		}
	}
	public void carregarCadastro() {
		try {
			if (codigo != null) {
				TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
				tipoAtividadeCadastro = tDAO.listarPorCodigo(codigo);
			} else {
				tipoAtividadeCadastro = new TiposAtividades();
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu ao tentar erro ao listar o Tipo de Atividade: " + e.getMessage());
		}
	}
	public void excluir() {
		try {
			TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
			tDAO.excluir(tipoAtividadeCadastro);

			FacesUtil.addMsgInfo("Tipo de Atividade excluido com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar excluir o Tipo de Atividade: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
			tDAO.alterar(tipoAtividadeCadastro);

			FacesUtil.addMsgInfo("Tipo de Atividade alterado com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar alterar o Tipo de Atividade: " + e.getMessage());
		}
	}
}
