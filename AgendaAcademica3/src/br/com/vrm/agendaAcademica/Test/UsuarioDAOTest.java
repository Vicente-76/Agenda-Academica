package br.com.vrm.agendaAcademica.Test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vrm.agendaAcademica.DAO.UsuariosDAO;
import br.com.vrm.agendaAcademica.Domain.Usuarios;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void incluir() {
		Usuarios u1 = new Usuarios();
		u1.setNome("Alex");
		u1.setSenha("4442");
		u1.setCurso("ADS");
		u1.setInstituicao("FATEC");
		u1.setCidade("Ourinhos");

		UsuariosDAO udao = new UsuariosDAO();

		udao.salvar(u1);

	}

	@Test
	@Ignore
	public void consultar() {
		UsuariosDAO dao = new UsuariosDAO();
		List<Usuarios> usuarios = dao.listar();
		for (Usuarios usuario : usuarios) {
			System.out.println(usuario);
		}
	}

	@Test
	@Ignore
	public void consultarPorCodigo() {
		UsuariosDAO dao = new UsuariosDAO();
		Usuarios u1 = dao.listarPorCodigo(9);
		Usuarios u2 = dao.listarPorCodigo(2);

		System.out.println(u1);
		System.out.println(u2);
	}

	// @Test
	// @Ignore
	// public void excluirUsuario() {
	// UsuarioDAO dao = new UsuarioDAO();
	// dao.excluir(8);
	// }

	@Test
	@Ignore
	public void alterar() {
		Usuarios usuario = new Usuarios();
		usuario.setCodUsuario(9);
		usuario.setNome("Izzy");
		usuario.setSenha("senha");
		usuario.setCurso("ADS");
		usuario.setInstituicao("Fatec Ourinhos");
		usuario.setCidade("OURINHOS-SP");

		UsuariosDAO dao = new UsuariosDAO();
		dao.alterar(usuario);
	}
}
