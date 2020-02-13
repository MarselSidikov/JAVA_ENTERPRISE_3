package ru.itdrive.jdbc.statements.repositories;

import java.util.List;

public interface CrudRepository<T> {
    void save(T object);
    void update(T object);
    void delete(Integer id);
    T find(Integer id);

    List<T> findAll();
}
