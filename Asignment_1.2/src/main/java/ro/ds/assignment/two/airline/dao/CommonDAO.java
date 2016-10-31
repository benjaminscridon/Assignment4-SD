package ro.ds.assignment.two.airline.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ro.ds.assignment.two.airline.exceptions.RepositoryException;
import ro.ds.assignment.two.airline.util.HibernateUtil;

public class CommonDAO<T> {

	private Transaction transaction;
	private Session session;

	public List<?> findAll(Class<?> clazz) throws RepositoryException {
		session = HibernateUtil.getSessionFactory().openSession();
		
		List<?> objects = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM " + clazz.getName());
			objects = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction) {
				transaction.rollback();
			}
			throw new RepositoryException();
		} finally {
			session.close();
		}
		return objects;
	}
}
