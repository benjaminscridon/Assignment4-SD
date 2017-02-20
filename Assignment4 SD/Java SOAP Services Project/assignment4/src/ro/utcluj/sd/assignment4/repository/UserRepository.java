package ro.utcluj.sd.assignment4.repository;

import ro.utcluj.sd.assignment4.entities.User;
import ro.utcluj.sd.assignment4.exceptions.RepositoryException;

public interface UserRepository extends BaseRepository<User>{

	User getByEmai(String email) throws RepositoryException;
}
