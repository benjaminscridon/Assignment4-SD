package ro.ds.assignment.two.airline.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ro.ds.assignment.two.airline.domain.Account;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;

public class AccountDAO {

	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Session session;

	public AccountDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Account findByUsername(String username) throws RepositoryException {
		session = sessionFactory.openSession();

		Account account = null;
		try {
			transaction = session.beginTransaction();
			account = (Account) session.createQuery("FROM Account WHERE username = :username")
					.setString("username", username).uniqueResult();
			transaction.commit();
		} catch (HibernateException exc) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RepositoryException("Username " + username + " city was not found.", exc);
		} finally {
			session.close();
		}
		return account;
	}

}
