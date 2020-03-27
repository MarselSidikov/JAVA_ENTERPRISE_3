package ru.itis.orm.spring;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.orm.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CoursesRepositoryJpaImpl implements CoursesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }
}
