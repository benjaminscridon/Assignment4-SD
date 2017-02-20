package ro.utcluj.sd.assignment4.repository.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ro.utcluj.sd.assignment4.entities.BaseEntity;
import ro.utcluj.sd.assignment4.exceptions.RepositoryException;
import ro.utcluj.sd.assignment4.repository.BaseRepository;
import ro.utcluj.sd.assignment4.repository.HibernateUtil;

public class BaseRepositoryBean<T extends BaseEntity> implements BaseRepository<T> {

	private Class<T> classType;

	public BaseRepositoryBean(Class<T> classType) {
		this.classType = classType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() throws RepositoryException{
		Transaction trns = null;
		List<T> items = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			items = session.createCriteria(classType).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			session.flush();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			throw new RepositoryException("Could not get all!");
		} finally {
			session.close();
		}
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) throws RepositoryException{
		Transaction trns = null;
		T item = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Criteria cr = session.createCriteria(classType);
			cr.add(Restrictions.eq("id", id));
			item = (T) cr.uniqueResult();
			session.flush();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			throw new RepositoryException("Could not get by id!");
		} finally {
			session.close();
		}
		return item;
	}

	@Override
	public T save(T item) throws RepositoryException {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(item);
			session.flush();
			trns.commit();
			return item;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			throw new RepositoryException("Could not insert!", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T item) throws RepositoryException {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(item);
			session.flush();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			throw new RepositoryException("Could not update!");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(T item) throws RepositoryException {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.delete(item);
			session.flush();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			throw new RepositoryException("Could not delete!");
		} finally {
			session.close();
		}

	}

}
