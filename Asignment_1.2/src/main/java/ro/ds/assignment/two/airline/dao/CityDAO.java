package ro.ds.assignment.two.airline.dao;

import org.hibernate.SessionFactory;

public class CityDAO {

	private SessionFactory sessionFactory;

	public CityDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
