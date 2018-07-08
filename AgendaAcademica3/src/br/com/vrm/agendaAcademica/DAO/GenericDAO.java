package br.com.vrm.agendaAcademica.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.vrm.agendaAcademica.Util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;

		try {
			t = s.beginTransaction();
			s.save(entidade);
			t.commit();
		} catch (RuntimeException ex) {
			if (t != null) {
				t.rollback();
			}
			throw ex;
		} finally {
			s.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query = s.createCriteria(classe);
			List<Entidade> rset = query.list();
			return rset;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			s.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade listarPorCodigo(int codigo) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query = s.createCriteria(classe);
			query.add(Restrictions.idEq(codigo));
			Entidade e = (Entidade) query.uniqueResult();
			return e;
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			s.close();
		}
	}

	public void excluir(Entidade entidade) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;

		try {
			t = s.beginTransaction();
			s.delete(entidade);
			;
			t.commit();
		} catch (RuntimeException ex) {
			if (t != null) {
				t.rollback();
			}
			throw ex;
		} finally {
			s.close();
		}
	}

	public void alterar(Entidade entidade) {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;

		try {
			t = s.beginTransaction();
			s.update(entidade);
			t.commit();
		} catch (RuntimeException ex) {
			if (t != null) {
				t.rollback();
			}
			throw ex;
		} finally {
			s.close();
		}
	}

}
