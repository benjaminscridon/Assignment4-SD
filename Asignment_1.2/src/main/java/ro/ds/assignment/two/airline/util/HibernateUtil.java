package ro.ds.assignment.two.airline.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Beniamin Scridon
 * @since 10/16/2016
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			init();
		}
		return sessionFactory;
	}
	
	private static void init(){
		sessionFactory = new Configuration()
				.configure("/hibernate-configurations/hibernate.cfg.xml")
				.buildSessionFactory();
	}
}
