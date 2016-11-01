package ro.ds.assignment.two.airline.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ro.ds.assignment.two.airline.domain.City;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;

public class CityDAO {

	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Session session;

	public CityDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public City findByName(String name) throws RepositoryException {
		session = sessionFactory.openSession();

		City city = null;
		try {
			transaction = session.beginTransaction();
			city = (City) session.createQuery("FROM City WHERE name = :name").setString("name", name).uniqueResult();
			transaction.commit();
		} catch (HibernateException exc) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RepositoryException(name + " city was not found.", exc);
		} finally {
			session.close();
		}
		return city;
	}

}
