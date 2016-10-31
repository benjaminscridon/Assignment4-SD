package ro.ds.assignment.two.airline.businesslogic;

import java.util.List;

import org.hibernate.cfg.Configuration;

import ro.ds.assignment.two.airline.dao.FlightDAO;
import ro.ds.assignment.two.airline.domain.Flight;

/**
 * 
 * @author Beniamin Scridon
 * @since Sunday,October 23,2016
 */
public class FlightService {

	private FlightDAO flightDAO;

	public FlightService() {
	}

	public List<Flight> getAllFlights() {
		if (null == flightDAO) {
			flightDAO = new FlightDAO(
					new Configuration()
					.configure("/hibernate-configurations/hibernate.cfg.xml")
					.buildSessionFactory());
		}
		
		return flightDAO.getAll();
	}

}
