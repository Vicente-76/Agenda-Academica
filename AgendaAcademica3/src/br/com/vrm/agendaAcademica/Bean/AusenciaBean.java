package br.com.vrm.agendaAcademica.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vrm.agendaAcademica.DAO.AusenciasDAO;
import br.com.vrm.agendaAcademica.DAO.DisciplinasDAO;
import br.com.vrm.agendaAcademica.Domain.Ausencias;
import br.com.vrm.agendaAcademica.Domain.Disciplinas;
import br.com.vrm.agendaAcademica.Util.FacesUtil;

@ManagedBean
@ViewScoped
public class AusenciaBean {
	private Ausencias ausenciaCadastro;

	public Ausencias getAusenciaCadastro() {
		return ausenciaCadastro;
	}

	public void setAusenciaCadastro(Ausencias ausenciaCadastro) {
		this.ausenciaCadastro = ausenciaCadastro;
	}
	
	private List<Ausencias> listaAusencias;

	public List<Ausencias> getListaAusencias() {
		return listaAusencias;
	}

	public void setListaAusencias(List<Ausencias> listaAusencia) {
		this.listaAusencias = listaAusencia;
	}
	
	private List<Ausencias> listaAusenciasFiltradas;

	public List<Ausencias> getListaAusenciasFiltradas() {
		return listaAusenciasFiltradas;
	}

	public void setListaAusenciasFiltradas(List<Ausencias> listaAusenciasFiltradas) {
		this.listaAusenciasFiltradas = listaAusenciasFiltradas;
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
	
	private List<Disciplinas> listaDisciplinas;

	public List<Disciplinas> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplinas> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
	
	public void novo() {
		ausenciaCadastro = new Ausencias();
	}
	
	public void salvar() {
		try {
			AusenciasDAO auDAO = new AusenciasDAO();
			auDAO.salvar(ausenciaCadastro);
			ausenciaCadastro = new Ausencias();
			FacesUtil.addMsgInfo("Ausencia salva com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar incluir uma Ausencia: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa() {
		try {
			AusenciasDAO auDAO = new AusenciasDAO();
			listaAusencias = auDAO.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao listar as Ausencias: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if (codigo != null) {
				AusenciasDAO auDAO = new AusenciasDAO();
				ausenciaCadastro = auDAO.listarPorCodigo(codigo);
			} else {
				ausenciaCadastro = new Ausencias();
			}
			
			DisciplinasDAO dDAO = new DisciplinasDAO();
			listaDisciplinas = dDAO.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu ao tentar erro ao carregar a Ausencia: " + e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			AusenciasDAO auDAO = new AusenciasDAO();
			auDAO.excluir(ausenciaCadastro);

			FacesUtil.addMsgInfo("Ausencia excluida com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar excluir a Ausencia: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			AusenciasDAO auDAO = new AusenciasDAO();
			auDAO.alterar(ausenciaCadastro);

			FacesUtil.addMsgInfo("Ausencia alterada com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar alterar a Ausencia: " + e.getMessage());
		}
	}
}
