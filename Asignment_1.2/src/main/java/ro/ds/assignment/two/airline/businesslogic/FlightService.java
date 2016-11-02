package ro.ds.assignment.two.airline.businesslogic;

import java.util.List;
import ro.ds.assignment.two.airline.dao.CommonDAO;
import ro.ds.assignment.two.airline.domain.Flight;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;
import ro.ds.assignment.two.airline.exceptions.ServiceException;

/**
 * 
 * @author Beniamin Scridon
 * @since Sunday,October 23,2016
 */
public class FlightService {

	private CommonDAO<Flight> commonDAO;

	public FlightService() {
		commonDAO = new CommonDAO<Flight>();
	}

	public void addFlight(Flight flight) throws ServiceException {
		try {
			commonDAO.saveOrUpdate(flight);
		} catch (RepositoryException exc) {
			throw new ServiceException("Aici modific, pentru data integrity Violation -invalid flight number");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getAllFlights() throws ServiceException {
		List<Flight> flights = null;
		try {
			flights = (List<Flight>) commonDAO.findAll(Flight.class);
		} catch (RepositoryException exc) {
			throw new ServiceException("Something went wrong, please try again!");
		}
		return flights;
	}

	public void deleteFlight(Flight flight) {
		try {
			commonDAO.delete(commonDAO.find(Flight.class, flight.getId()));
		} catch (RepositoryException exc) {
			throw new ServiceException("There is a problem to delete selected flight.");
		}
	}

	public Flight findFlight(int id) {
		try {
			return (Flight) commonDAO.find(Flight.class, id);
		} catch (RepositoryException exc) {
			throw new ServiceException("Flight not found..");
		}
	}

	public void updateFlight(Flight flight) {
		try {
			commonDAO.update(flight);
		} catch (RepositoryException exc) {
			throw new ServiceException("Cannot update..");
		}
	}

}
