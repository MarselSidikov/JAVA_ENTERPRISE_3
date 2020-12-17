package ru.itis.search.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.search.models.Comment;

/**
 * 15.12.2020
 * search-example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
