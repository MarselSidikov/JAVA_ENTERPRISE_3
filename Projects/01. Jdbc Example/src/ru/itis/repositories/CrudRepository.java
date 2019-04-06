package ru.itis.repositories;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    void save(T model);
    void update(T model);
    void delete(ID id);
    Optional<T> find(ID id);

    List<T> findAll();
}
