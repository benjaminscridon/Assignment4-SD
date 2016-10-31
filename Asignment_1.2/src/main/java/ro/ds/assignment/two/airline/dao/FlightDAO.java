package ro.ds.assignment.two.airline.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ro.ds.assignment.two.airline.domain.Flight;

/**
 * 
 * @author Beniamin Scridon
 * @since Sunday,October 23,2016
 */
public class FlightDAO {

	private SessionFactory factory;

	public FlightDAO(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getAll() {
		Session session = factory.openSession();
		List<Flight> flights = session.createCriteria(Flight.class).list();
		session.close();
		return flights;
	}
}
