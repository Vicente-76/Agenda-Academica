package br.com.vrm.agendaAcademica.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vrm.agendaAcademica.DAO.UsuariosDAO;
import br.com.vrm.agendaAcademica.Domain.Usuarios;
import br.com.vrm.agendaAcademica.Util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Usuarios usuarioCadastro;

	public Usuarios getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuarios usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	private List<Usuarios> listaUsuarios;

	public List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	private List<Usuarios> listaUsuariosFiltrados;

	public List<Usuarios> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuarios> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
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
		usuarioCadastro = new Usuarios();
	}

	public void salvar() {
		try {
			UsuariosDAO uDAO = new UsuariosDAO();
			uDAO.salvar(usuarioCadastro);
			usuarioCadastro = new Usuarios();
			FacesUtil.addMsgInfo("Usuario salvo com sucesso");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar incluir o Usuário: " + e.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			UsuariosDAO uDAO = new UsuariosDAO();
			listaUsuarios = uDAO.listar();
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao listar os Usuários: " + e.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				UsuariosDAO uDAO = new UsuariosDAO();
				usuarioCadastro = uDAO.listarPorCodigo(codigo);
			} else {
				usuarioCadastro = new Usuarios();
			}
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu ao tentar erro ao carregar o Usuário: " + e.getMessage());
		}
	}

	public void excluir() {
		try {
			UsuariosDAO uDAO = new UsuariosDAO();
			uDAO.excluir(usuarioCadastro);

			FacesUtil.addMsgInfo("Usuario excluido com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar excluir o Usuário: " + e.getMessage());
		}
	}

	public void editar() {
		try {
			UsuariosDAO uDAO = new UsuariosDAO();
			uDAO.alterar(usuarioCadastro);

			FacesUtil.addMsgInfo("Usuario alterado com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Ocorreu um erro ao tentar alterar o Usuário: " + e.getMessage());
		}
	}
}
