package ro.ds.assignment.two.airline.businesslogic;

import java.util.List;
import ro.ds.assignment.two.airline.dao.CommonDAO;
import ro.ds.assignment.two.airline.domain.City;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;
import ro.ds.assignment.two.airline.exceptions.ServiceException;

public class CityService {

	private CommonDAO<City> commonDAO;

	public CityService() {
		commonDAO = new CommonDAO<City>();
	}

	@SuppressWarnings("unchecked")
	public List<City> getAllCities() throws ServiceException {
		try {
			return (List<City>) commonDAO.findAll(City.class);
		} catch (RepositoryException exception) {
			throw new ServiceException("Sorry, something went wrong.Please try again.");
		}
	}
}
