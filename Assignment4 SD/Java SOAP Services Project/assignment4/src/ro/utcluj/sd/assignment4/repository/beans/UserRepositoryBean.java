package ro.utcluj.sd.assignment4.repository.beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ro.utcluj.sd.assignment4.entities.User;
import ro.utcluj.sd.assignment4.exceptions.RepositoryException;
import ro.utcluj.sd.assignment4.repository.HibernateUtil;
import ro.utcluj.sd.assignment4.repository.UserRepository;

public class UserRepositoryBean extends BaseRepositoryBean<User> implements UserRepository {
	public UserRepositoryBean() {
		super(User.class);
	}

	@Override
	public User getByEmai(String email) throws RepositoryException {
		Transaction trns = null;
		User item = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			item =  (User) session.createQuery("select u from User u where u.email = :email")
			           .setString("email", email)
			           .uniqueResult();
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
}
