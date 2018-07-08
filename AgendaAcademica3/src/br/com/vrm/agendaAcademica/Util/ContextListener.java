package br.com.vrm.agendaAcademica.Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().close();
	}
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().openSession();
	}
}
