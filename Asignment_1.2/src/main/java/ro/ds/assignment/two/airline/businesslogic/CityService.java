package ro.ds.assignment.two.airline.businesslogic;

import java.util.List;

import ro.ds.assignment.two.airline.dao.CityDAO;
import ro.ds.assignment.two.airline.dao.CommonDAO;
import ro.ds.assignment.two.airline.domain.City;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;
import ro.ds.assignment.two.airline.exceptions.ServiceException;
import ro.ds.assignment.two.airline.util.HibernateUtil;

public class CityService {

	private CommonDAO<City> commonDAO;
	private CityDAO cityDAO;

	public CityService() {
		commonDAO = new CommonDAO<City>();
		cityDAO = new CityDAO(HibernateUtil.getSessionFactory());
	}

	@SuppressWarnings("unchecked")
	public List<City> getAllCities() throws ServiceException {
		try {
			return (List<City>) commonDAO.findAll(City.class);
		} catch (RepositoryException exception) {
			throw new ServiceException("Sorry, something went wrong.Please try again.");
		}
	}

	public City findCityByName(String name) throws ServiceException {
		City city = null;
		try {
			city = cityDAO.findByName(name);
		} catch (RepositoryException exc) {
			throw new ServiceException(exc.getMessage());
		}
		return city;
	}
}
