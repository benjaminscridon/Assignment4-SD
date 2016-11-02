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
		List<?> objects = null;

		try {
			startOperation();
			Query query = session.createQuery("FROM " + clazz.getName());
			objects = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction) {
				transaction.rollback();
			}
			// /throw new RepositoryException(e);
		} finally {
			session.close();
		}
		return objects;
	}

	public void saveOrUpdate(Object object) throws RepositoryException {
		try {
			startOperation();
			session.saveOrUpdate(object);
			transaction.commit();
		} catch (HibernateException exc) {
			if (null != transaction) {
				transaction.rollback();
			}
			// throw new RepositoryException(exc);
		} finally {
			session.close();
		}
	}

	 public Object find(Class clazz, int id) {
	        Object obj = null;
	        try {
	            startOperation();
	            obj = session.load(clazz, id);
	            transaction.commit();
	        } catch (HibernateException e) {
	        	
	        } finally {
	        	session.close();
	        }
	        return obj;
	    }

	 public void update(Object object) throws RepositoryException {
			try {
				startOperation();
				session.update(object);
				transaction.commit();
			} catch (RuntimeException e) {
				if (transaction != null) {
					transaction.rollback();
				}
				throw new RepositoryException("Could not update!");
			} finally {
				session.close();
			}
		}

	
	
	public void delete(Object obj) {
		try {
			startOperation();
			session.delete(obj);
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction) {
				transaction.rollback();
			}
			// throw new RepositoryException(e);
		} finally {
			session.close();
		}
	}

	protected void startOperation() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}
}
