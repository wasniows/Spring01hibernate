package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    List<Book> findAllByAuthorList(Author author);

    List<Book> findAllByCategoryName(String categoryName);

    List<Book> findAllByCategoryId(Long categoryId);

    List<Book> findAllByPublisherName(String publisherName);

    List<Book> findFirstByCategoryNameOrderByTitle(String firstByCategoryOrderByTitle);
}



