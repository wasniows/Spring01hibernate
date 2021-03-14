package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Book> findAll() {
        Query query = entityManager.createQuery("select b from Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query ratingListQuery = entityManager.createQuery("select b from Book b where b.rating = :rating");
        ratingListQuery.setParameter("rating", rating);
        return ratingListQuery.getResultList();
    }

    public List<Book> findAllWithPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher");
        return query.getResultList();
    }

    public List<Book> getBookByPublisher(Long id) {
        Query booksByPublisherQuery = entityManager.createQuery("select b from Book b where b.publisher.id=:id");
        booksByPublisherQuery.setParameter("id", id);
        return booksByPublisherQuery.getResultList();
    }

    public List<Book> getBookByAuthor(Author author) {
        Query booksByPublisherQuery = entityManager.createQuery("select b from Book b where :author member of b.authorList");
        booksByPublisherQuery.setParameter("author", author);
        return booksByPublisherQuery.getResultList();
    }
}
