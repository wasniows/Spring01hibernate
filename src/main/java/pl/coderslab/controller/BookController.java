package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@RequestMapping(produces = "text/html; charset=UTF-8")
@Controller
public class BookController {
    private final BookDao bookDao;
    public BookController(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @RequestMapping( path = "/book/add" )
    @ResponseBody
    public String addBook(){
        Book book = new Book();
        book.setTitle("Król");
        book.setDescription("Publikacja świetnie przedstawia realia Warszawy lat trzydziestych XX wieku. Konflikty, emocje, zaskakujące zwroty akcji, drogie samochody, boks, luksusowe burdele i dzielnice nędzy. Obraz żydowskiego bohatera, Polacy, getto, różnice etniczne i światopoglądowe. Sła - zasada, którą rządzi się gangsterski świat. ");
        book.setRating(9);
        bookDao.saveBook(book);
        return "Id dodanej książki to: " + book.getId();
    }

    @RequestMapping(path = "/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id){
        Book book = bookDao.findById(id);
        return book.toString();
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
