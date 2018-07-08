package br.com.vrm.agendaAcademica.Test;

import org.junit.Test;

import br.com.vrm.agendaAcademica.Util.HibernateUtil;

public class GerarTabelaTest {
	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
