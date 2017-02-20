package ro.utcluj.sd.assignment4.repository;

import java.util.List;

import ro.utcluj.sd.assignment4.entities.BaseEntity;
import ro.utcluj.sd.assignment4.exceptions.RepositoryException;

public interface BaseRepository<T extends BaseEntity> {

    List<T> getAll() throws RepositoryException;

    T getById(Long id) throws RepositoryException;

    T save(T item) throws RepositoryException;

    void update(T item) throws RepositoryException;

    void delete(T item) throws RepositoryException;
}
