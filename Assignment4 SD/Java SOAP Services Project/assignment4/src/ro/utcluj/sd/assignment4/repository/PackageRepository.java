package ro.utcluj.sd.assignment4.repository;

import java.util.List;

import ro.utcluj.sd.assignment4.entities.Package;

public interface PackageRepository extends BaseRepository<Package>{
	public List<Package> getPackagesByNameOrId(String name, long id);
}
