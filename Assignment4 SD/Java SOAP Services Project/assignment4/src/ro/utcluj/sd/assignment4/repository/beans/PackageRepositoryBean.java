package ro.utcluj.sd.assignment4.repository.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ro.utcluj.sd.assignment4.entities.Package;
import ro.utcluj.sd.assignment4.entities.User;
import ro.utcluj.sd.assignment4.exceptions.RepositoryException;
import ro.utcluj.sd.assignment4.repository.HibernateUtil;
import ro.utcluj.sd.assignment4.repository.PackageRepository;

public class PackageRepositoryBean extends BaseRepositoryBean<Package> implements PackageRepository {

	public PackageRepositoryBean() {
		super(Package.class);
	}
	
	@Override
	public List<Package> getPackagesByNameOrId(String name, long id) {
		Transaction trns = null;
		List<Package> items = new ArrayList<Package>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			items =  session.createQuery("select p from Package p where p.name = :name or p.id = :id")
			           .setString("name", name)
			           .setParameter("id", id).list();


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
		return items;
	}

}
