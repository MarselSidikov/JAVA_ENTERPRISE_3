package ru.itdrive.web.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itdrive.web.models.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * 23.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class MessagesRepositoryJpaImpl implements MessagesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Message> find(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Message> findAll() {
        return entityManager.createQuery("from Message", Message.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Message entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Message entity) {

    }
}
