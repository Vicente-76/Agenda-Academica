package br.com.vrm.agendaAcademica.Bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.vrm.agendaAcademica.DAO.UsuariosDAO;
import br.com.vrm.agendaAcademica.Domain.Usuarios;
import br.com.vrm.agendaAcademica.Util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuarios usuarioLogado;

	public Usuarios getUsuarioLogado() {
		if(usuarioLogado == null) {
			usuarioLogado = new Usuarios();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuarios usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	private String acao;

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public void autenticar() throws IOException {
		try {
			UsuariosDAO usuarioDAO = new UsuariosDAO();
			usuarioLogado = usuarioDAO.autenticar(usuarioLogado.getNome(), usuarioLogado.getSenha());
			if(usuarioLogado == null) {
				FacesUtil.addMsgError("Nome e/ou senha inválidos!!");
			}else {
				FacesUtil.addMsgInfo("Usuario autenticado com sucesso!!");
			}
			
		} catch(RuntimeException ex) {
			FacesUtil.addMsgError("Erro ao tentar Logar no sistema: "+ ex.getMessage());
		}
	}
	
	public String sair(){
		usuarioLogado = null;
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}
}
