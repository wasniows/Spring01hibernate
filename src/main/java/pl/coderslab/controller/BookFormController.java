package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import java.util.Collection;
import java.util.List;


@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/listofbooks")
    public String listOfBooks(){
        return "listOfBooks.jsp";
    }

    @GetMapping("/addbook")
    public String formBook(Model model){
        model.addAttribute("book", new Book());
        return "addBook.jsp";
    }

    @PostMapping("/addbook")
    public String addBook (Book book){
        bookDao.saveBook(book);
        return "/book.jsp";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @ModelAttribute("books")
    public Collection<Book> books(){
        return this.bookDao.findAll();
    }
}
