package ru.itdrive.web.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> find(Long id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
}
