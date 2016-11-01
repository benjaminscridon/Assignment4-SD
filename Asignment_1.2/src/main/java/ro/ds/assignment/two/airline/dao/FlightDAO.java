package ro.ds.assignment.two.airline.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ro.ds.assignment.two.airline.domain.City;
import ro.ds.assignment.two.airline.domain.Flight;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;

/**
 * 
 * @author Beniamin Scridon
 * @since Sunday,October 23,2016
 */
public class FlightDAO {

	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Session session;


	public FlightDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
