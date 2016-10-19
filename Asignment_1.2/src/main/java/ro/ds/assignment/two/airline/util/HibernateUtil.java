package ro.ds.assignment.two.airline.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ro.ds.assignment.two.airline.domain.Account;


/**
 * 
 * @author Beniamin Scridon
 * @since 10/16/2016
 */
public class HibernateUtil {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("/hibernate-configurations/hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (session.isOpen()) {
				
				Account account =new Account();
				account.setPassword("password");
				account.setRole("administrator");
				account.setUsername("username_4126699904");
				
				int i =  (Integer) session.save(account);
				
				System.out.println("Success."+ i);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
	}
}
