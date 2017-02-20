package ro.utcluj.sd.assignment4.service;

import ro.utcluj.sd.assignment4.dto.PackageDTO;
import ro.utcluj.sd.assignment4.entities.RouteItem;
import ro.utcluj.sd.assignment4.exceptions.ServiceException;

public interface PackageService {
	public void addPackage(PackageDTO p) throws ServiceException;
	public void deletePackage(PackageDTO p) throws ServiceException;
	public void setPackageTrackable(boolean trackable, long packageId) throws ServiceException;
	public void addRouteItemToPackage(RouteItem routeItem, long packageId) throws ServiceException;
	public PackageDTO[] getPackagesByNameOrId(String name, long id) throws ServiceException;
	public PackageDTO[] getAllPackages() throws ServiceException;
}
