package ro.utcluj.sd.assignment4.service;

import java.util.List;

import ro.utcluj.sd.assignment4.assembler.Assembler;
import ro.utcluj.sd.assignment4.dto.PackageDTO;
import ro.utcluj.sd.assignment4.entities.Package;
import ro.utcluj.sd.assignment4.entities.RouteItem;
import ro.utcluj.sd.assignment4.entities.User;
import ro.utcluj.sd.assignment4.exceptions.RepositoryException;
import ro.utcluj.sd.assignment4.exceptions.ServiceException;
import ro.utcluj.sd.assignment4.repository.PackageRepository;
import ro.utcluj.sd.assignment4.repository.RouteItemRepository;
import ro.utcluj.sd.assignment4.repository.UserRepository;
import ro.utcluj.sd.assignment4.repository.beans.PackageRepositoryBean;
import ro.utcluj.sd.assignment4.repository.beans.RouteItemRepositoryBean;
import ro.utcluj.sd.assignment4.repository.beans.UserRepositoryBean;

public class PackageServiceBean implements PackageService {

	public void addPackage(PackageDTO p) {
		PackageRepository packageRepository = new PackageRepositoryBean();
		UserRepository userRepository = new UserRepositoryBean();
		try {
			Package pack = Assembler.dTOToPackage(p);
			User sender = pack.getSender();
			User receiver = pack.getReceiver();
			
			User dbSender = userRepository.getByEmai(sender.getEmail());
			if(dbSender == null){
				dbSender = userRepository.save(sender);
			}
			pack.setSender(dbSender);
			
			User dbReceiver = userRepository.getByEmai(receiver.getEmail());
			if(dbReceiver == null){
				dbReceiver = userRepository.save(receiver);
			}
			pack.setReceiver(dbReceiver);

			packageRepository.save(pack);
		} catch (RepositoryException e) {
			throw new ServiceException("cannot add package", e);
		}

	}

	public void deletePackage(PackageDTO p) {
		PackageRepository packageRepository = new PackageRepositoryBean();
		try {
			Package dbPackage = packageRepository.getById(p.getId());
			packageRepository.delete(dbPackage);
		} catch (RepositoryException e) {
			throw new ServiceException("cannot delete package", e);
		}

	}

	public void setPackageTrackable(boolean trackable, long packageId) {
		PackageRepository packageRepository = new PackageRepositoryBean();
		Package p = null;
		try {
			p = packageRepository.getById(packageId);
			p.setTacking(!p.isTacking());
			packageRepository.update(p);
		} catch (RepositoryException e) {
			throw new ServiceException("cannot update package", e);
		}

	}

	public void addRouteItemToPackage(RouteItem routeItem, long packageId) {
		PackageRepository packageRepository = new PackageRepositoryBean();
		RouteItemRepository routeItemRepository = new RouteItemRepositoryBean();

		RouteItem r = null;
		Package p = null;
		try {
			r = routeItemRepository.save(routeItem);
			p = packageRepository.getById(packageId);
			p.getRoute().add(r);
			packageRepository.update(p);

		} catch (RepositoryException e) {
			throw new ServiceException("cannot add route item to package's route", e);
		}

	}

	public PackageDTO[] getPackagesByNameOrId(String name, long id) {
		PackageRepository packageRepository = new PackageRepositoryBean();
		try {
			List<Package> list = packageRepository.getPackagesByNameOrId(name, id);
			PackageDTO[] array = new PackageDTO[list.size()];
			for (int i = 0; i < list.size(); i++)
				array[i] = Assembler.packageToDTO(list.get(i));
			return array;
		} catch (RepositoryException e) {
			throw new ServiceException("cannot get packages", e);
		}
	}

	public PackageDTO[] getAllPackages() {
		PackageRepository packageRepository = new PackageRepositoryBean();
		try {
			List<Package> list = packageRepository.getAll();
			PackageDTO[] array = new PackageDTO[list.size()];
			for (int i = 0; i < list.size(); i++)
				array[i] = Assembler.packageToDTO(list.get(i));
			return array;
		} catch (RepositoryException e) {
			throw new ServiceException("cannot get packages", e);
		}
	}

}
