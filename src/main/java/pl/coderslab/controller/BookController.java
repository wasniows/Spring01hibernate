package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequestMapping(produces = "text/html; charset=UTF-8")
@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping( path = "/book/add" )
    @ResponseBody
    public String addBook(){
        Book book = new Book();
        Publisher publisher = new Publisher();
        publisher.setName("Znak");
        publisherDao.savePublisher(publisher);
        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(2);
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        book.setAuthorList(authors);
        book.setTitle("Król");
        book.setDescription("Publikacja świetnie przedstawia realia Warszawy lat trzydziestych XX wieku. Konflikty, emocje, zaskakujące zwroty akcji, drogie samochody, boks, luksusowe burdele i dzielnice nędzy. Obraz żydowskiego bohatera, Polacy, getto, różnice etniczne i światopoglądowe. Sła - zasada, którą rządzi się gangsterski świat. ");
        book.setRating(9);
        book.setPublisher(publisher);

        bookDao.saveBook(book);
        return "Id dodanej książki to: " + book.getId();
    }

    @RequestMapping(path = "/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id){
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping(path = "/book/rating/{id}")
    @ResponseBody
    public String getRatingBook(@PathVariable int id){
        List<Book> books = bookDao.getRatingList(id);
        return books.toString();
    }

    @RequestMapping(path = "/book/publisher")
    @ResponseBody
    public String getBooksByPublisher(){
        List<Book> books = bookDao.findAllWithPublisher();
        return books.toString();
    }

    @RequestMapping(path = "/book/publisher/{id}")
    @ResponseBody
    public String getBooksByPublisherId(@PathVariable Long id){
        List<Book> books = bookDao.getBookByPublisher(id);
        return books.toString();
    }

    @RequestMapping(path = "/book/get/all")
    @ResponseBody
    public String getAllBooks(){
        List<Book> books = bookDao.findAll();
        return Objects.nonNull(books) ? books.toString() : "Brak listy książek";
    }

    @RequestMapping(path = "/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title){
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping(path = "/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id){
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }
}
