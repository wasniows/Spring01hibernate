package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(pl.coderslab.entity.Book book) {
        entityManager.persist(book);
    }

    public pl.coderslab.entity.Book findById(long id) {
        return entityManager.find(pl.coderslab.entity.Book.class, id);
    }

    public void update(pl.coderslab.entity.Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }
}
