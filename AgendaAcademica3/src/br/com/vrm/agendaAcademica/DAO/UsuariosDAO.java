package br.com.vrm.agendaAcademica.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.vrm.agendaAcademica.Domain.Usuarios;
import br.com.vrm.agendaAcademica.Util.HibernateUtil;

public class UsuariosDAO extends GenericDAO<Usuarios> {
	public Usuarios autenticar(String nome, String senha) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria query = s.createCriteria(Usuarios.class);
			
			query.add(Restrictions.eq("nome", nome));

			query.add(Restrictions.eq("senha", senha));
			
			Usuarios resultado = (Usuarios) query.uniqueResult();
			
			return resultado;
		} catch(RuntimeException erro) {
			throw erro;
		} finally {
			s.close();		
		}
	}
	public boolean auth(String nome, String senha) {
		boolean ret=false;
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria query = s.createCriteria(Usuarios.class);
			
			query.add(Restrictions.eq("nome", nome));

			query.add(Restrictions.eq("senha", senha));
			
			Usuarios resultado = (Usuarios) query.uniqueResult();
			
			if (resultado!=null) {
				ret=true;
			};
		} catch(RuntimeException erro) {
			
		} finally {
			s.close();		
		}
		return ret;
	}
}
